package org.michaelbel.template.features.tmdb_api.di

import android.content.Context
import com.ashokvarma.gander.GanderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.michaelbel.core.di.qualifiers.ConverterFactorySerialization
import org.michaelbel.template.Constants
import org.michaelbel.template.features.tmdb_api.api.MovieApi
import org.michaelbel.template.features.tmdb_api.api.MoviesApi
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
    @TmdbRetrofit
    fun provideRetrofit(
        @TmdbBaseUrl baseUrl: String,
        @ConverterFactorySerialization converterFactory: Converter.Factory,
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
    fun provideMovieApi(
        @TmdbRetrofit retrofit: Retrofit
    ): MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideMoviesApi(
        @TmdbRetrofit retrofit: Retrofit
    ): MoviesApi = retrofit.create(MoviesApi::class.java)
}