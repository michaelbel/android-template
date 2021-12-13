package org.michaelbel.template.features.tmdb_api.di

import android.content.Context
import com.ashokvarma.gander.Gander
import com.ashokvarma.gander.GanderInterceptor
import com.ashokvarma.gander.imdb.GanderIMDB
import com.ashokvarma.gander.persistence.GanderPersistence
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.michaelbel.template.Constants
import org.michaelbel.template.features.tmdb_api.api.MovieApi
import retrofit2.Converter
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @TmdbBaseUrl
    fun provideBaseUrl(): String = Constants.TMDB_API_ENDPOINT

    @Provides
    @Singleton
    fun provideGanderInterceptor(@ApplicationContext context: Context): GanderInterceptor {
        Gander.setGanderStorage(GanderPersistence.getInstance(context))
        Gander.setGanderStorage(GanderIMDB.getInstance())
        return GanderInterceptor(context)
            .showNotification(true)
            .maxContentLength(250000L)
            .retainDataFor(GanderInterceptor.Period.ONE_HOUR)
    }

    @Provides
    @Singleton
    @TmdbOkhttp
    fun provideOkHttp(
        @ApplicationContext context: Context,
        ganderInterceptor: GanderInterceptor
    ): OkHttpClient {
        val cacheSize: Long = 10 * 1024L * 1024L
        val cache = Cache(
            directory = context.cacheDir,
            maxSize = cacheSize
        )
        val callTimeoutDuration: Pair<Long, TimeUnit> = 0L to TimeUnit.SECONDS // суммарное время на выполнение запроса (нет ограничений).
        val connectTimeoutDuration: Pair<Long, TimeUnit> = 10L to TimeUnit.SECONDS // время на подключение к заданному хосту.
        val readTimeoutDuration: Pair<Long, TimeUnit> = 10L to TimeUnit.SECONDS // время на получение ответа сервера.
        val writeTimeoutDuration: Pair<Long, TimeUnit> = 10L to TimeUnit.SECONDS // время на передачу запроса серверу.
        val builder = OkHttpClient.Builder().apply {
            cache(cache)
            retryOnConnectionFailure(false)
            addInterceptor(ganderInterceptor)
            callTimeout(callTimeoutDuration.first, callTimeoutDuration.second)
            connectTimeout(connectTimeoutDuration.first, connectTimeoutDuration.second)
            readTimeout(readTimeoutDuration.first, readTimeoutDuration.second)
            writeTimeout(writeTimeoutDuration.first, writeTimeoutDuration.second)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    @TmdbConverterFactory
    fun provideConverterFactory(): Converter.Factory {
        val contentType: MediaType = "application/json".toMediaType()
        return Json.asConverterFactory(contentType)
    }

    @Provides
    @Singleton
    @TmdbRetrofit
    fun provideRetrofit(
        @TmdbBaseUrl baseUrl: String,
        @TmdbConverterFactory converterFactory: Converter.Factory,
        @TmdbOkhttp okHttpClient: OkHttpClient
    ): Retrofit {
        val builder = Retrofit.Builder().apply {
            baseUrl(baseUrl)
            addConverterFactory(converterFactory)
            client(okHttpClient)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideMovieApi(@TmdbRetrofit retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
}