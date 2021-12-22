package org.michaelbel.core.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.michaelbel.core.di.qualifiers.DefaultApplicationScope
import org.michaelbel.core.di.qualifiers.DefaultDispatcher
import org.michaelbel.core.di.qualifiers.MainApplicationScope
import org.michaelbel.core.di.qualifiers.MainDispatcher

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesScopesModule {

    @Provides
    @Singleton
    @DefaultApplicationScope
    fun provideDefaultCoroutineScope(
        @DefaultDispatcher dispatcher: CoroutineDispatcher
    ): CoroutineScope {
        return CoroutineScope(SupervisorJob() + dispatcher)
    }

    @Provides
    @Singleton
    @MainApplicationScope
    fun provideMainCoroutineScope(
        @MainDispatcher dispatcher: CoroutineDispatcher
    ): CoroutineScope {
        return CoroutineScope(SupervisorJob() + dispatcher)
    }
}