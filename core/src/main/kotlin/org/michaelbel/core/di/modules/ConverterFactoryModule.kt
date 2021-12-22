package org.michaelbel.core.di.modules

import com.google.gson.Gson
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import org.michaelbel.core.di.qualifiers.ConverterFactoryGson
import org.michaelbel.core.di.qualifiers.ConverterFactoryMoshi
import org.michaelbel.core.di.qualifiers.ConverterFactorySerialization
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ConverterFactoryModule {

    @Provides
    @Singleton
    @ConverterFactoryGson
    fun provideGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    @ConverterFactoryMoshi
    fun provideMoshiConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    @ConverterFactorySerialization
    fun provideSerializationConverterFactory(): Converter.Factory {
        val contentType: MediaType = "application/json".toMediaType()
        return Json.asConverterFactory(contentType)
    }
}