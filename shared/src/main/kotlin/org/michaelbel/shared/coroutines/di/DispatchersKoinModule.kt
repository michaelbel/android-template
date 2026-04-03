package org.michaelbel.shared.coroutines.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.michaelbel.shared.coroutines.AppDispatchers
import org.michaelbel.shared.coroutines.impl.AppDispatchersImpl

val dispatchersKoinModule = module {
    singleOf(::AppDispatchersImpl) { bind<AppDispatchers>() }
}
