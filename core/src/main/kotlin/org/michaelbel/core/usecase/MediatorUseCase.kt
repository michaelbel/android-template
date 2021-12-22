package org.michaelbel.core.usecase

import androidx.lifecycle.MediatorLiveData
import org.michaelbel.core.model.Either

abstract class MediatorUseCase<in P, R> {

    protected val result = MediatorLiveData<Either<R>>()

    open fun observe(): MediatorLiveData<Either<R>> {
        return result
    }

    abstract fun execute(parameters: P)
}