package org.michaelbel.shared.dispatchers.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.michaelbel.shared.dispatchers.AppDispatchers
import org.michaelbel.shared.dispatchers.impl.AppDispatchersImpl

val dispatchersKoinModule = module {
    singleOf(::AppDispatchersImpl) { bind<AppDispatchers>() }
}
