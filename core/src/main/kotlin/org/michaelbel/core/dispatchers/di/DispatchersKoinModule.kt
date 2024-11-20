package org.michaelbel.core.dispatchers.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.michaelbel.core.dispatchers.AppDispatchers
import org.michaelbel.core.dispatchers.impl.AppDispatchersImpl

val dispatchersKoinModule = module {
    singleOf(::AppDispatchersImpl) { bind<AppDispatchers>() }
}