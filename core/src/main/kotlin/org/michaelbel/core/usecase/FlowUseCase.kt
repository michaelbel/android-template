@file:Suppress("unused")

package org.michaelbel.core.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import org.michaelbel.core.model.Either

abstract class FlowUseCase<in P, R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    operator fun invoke(parameters: P): Flow<Either<R>> = execute(parameters)
        .catch { e -> emit(Either.Failure(Exception(e))) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<Either<R>>
}