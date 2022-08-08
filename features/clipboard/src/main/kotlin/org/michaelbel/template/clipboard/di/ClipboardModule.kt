package org.michaelbel.template.clipboard.di

import android.content.ClipboardManager
import android.content.Context
import androidx.core.content.ContextCompat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object ClipboardModule {

    @Provides
    fun provideClipboardService(
        @ApplicationContext context: Context
    ): ClipboardManager {
        return ContextCompat.getSystemService(
            context,
            ClipboardManager::class.java
        ) as ClipboardManager
    }
}