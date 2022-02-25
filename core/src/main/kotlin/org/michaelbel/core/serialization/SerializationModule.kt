package org.michaelbel.core.serialization

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter

@Module
@InstallIn(SingletonComponent::class)
object SerializationModule {

    @Provides
    fun provideSerializationConverterFactory(): Converter.Factory {
        val contentType: MediaType = "application/json".toMediaType()
        val json = Json {
            explicitNulls = false
            ignoreUnknownKeys = true
        }
        return json.asConverterFactory(contentType)
    }
}