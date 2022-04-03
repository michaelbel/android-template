package org.michaelbel.core.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.michaelbel.core.model.Either
import timber.log.Timber

abstract class UseCase<in P, R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(parameters: P): Either<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let { Either.Success(it) }
            }
        } catch (e: Exception) {
            Timber.e(e)
            Either.Failure(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}