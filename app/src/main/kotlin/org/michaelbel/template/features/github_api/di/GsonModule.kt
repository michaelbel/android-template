package org.michaelbel.template.features.github_api.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object GsonModule {

    @Provides
    fun provideGson(): Gson {
        val builder = GsonBuilder().apply {
            setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        }
        return builder.create()
    }

    @Provides
    @GitHubConverterFactory
    fun provideGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }
}