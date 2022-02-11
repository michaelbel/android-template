package org.michaelbel.template.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import org.michaelbel.template.app.data.AppDatabase
import org.michaelbel.template.app.data.dao.MovieDao

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.instance(context)
    }

    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao
}