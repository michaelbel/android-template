package org.michaelbel.template

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.michaelbel.shared.di.appDataKoinModule
import org.michaelbel.template.ui.list.ListViewModel
import org.michaelbel.template.ui.details2.DetailsViewModel2

val appModule = module {
    includes(appDataKoinModule)
    viewModelOf(::MainViewModel)
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailsViewModel2)
}
