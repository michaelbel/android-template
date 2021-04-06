package org.michaelbel.template.app.di

import android.content.Context
import com.ashokvarma.gander.Gander
import com.ashokvarma.gander.GanderInterceptor
import com.ashokvarma.gander.imdb.GanderIMDB
import com.ashokvarma.gander.persistence.GanderPersistence
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.michaelbel.template.Constants
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    fun provideGson(): Gson {
        val builder = GsonBuilder().apply {
            setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        }
        return builder.create()
    }

    @Provides
    fun provideConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

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
    fun provideOkHttp(
        @ApplicationContext context: Context,
        ganderInterceptor: GanderInterceptor
    ): OkHttpClient {
        val cacheSize: Long = 10 * 1024L * 1024L
        val cache = Cache(context.cacheDir, cacheSize)

        val builder = OkHttpClient.Builder().apply {
            cache(cache)
            retryOnConnectionFailure(false)
            addInterceptor(ganderInterceptor)
            connectTimeout(1L, TimeUnit.MINUTES)
            readTimeout(1L, TimeUnit.MINUTES)
            writeTimeout(1L, TimeUnit.MINUTES)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        val builder = Retrofit.Builder().apply {
            baseUrl(Constants.TMDB_API_ENDPOINT)
            addConverterFactory(converterFactory)
            client(okHttpClient)
        }
        return builder.build()
    }
}