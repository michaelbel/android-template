package org.michaelbel.template.inappreview

import android.content.Context
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ReviewModule {

    @Provides
    fun provideReviewManager(
        @ApplicationContext context: Context
    ): ReviewManager {
        return ReviewManagerFactory.create(context)
    }
}