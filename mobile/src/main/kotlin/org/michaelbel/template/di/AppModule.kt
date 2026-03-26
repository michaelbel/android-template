package org.michaelbel.template.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.michaelbel.shared.di.appDataKoinModule
import org.michaelbel.template.MainViewModel
import org.michaelbel.template.ui.details.DetailsViewModel
import org.michaelbel.template.ui.details2.DetailsViewModel2
import org.michaelbel.template.ui.list.ListViewModel
import org.michaelbel.template.ui.settings.SettingsViewModel

val appModule = module {
    includes(appDataKoinModule)
    viewModelOf(::MainViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailsViewModel)
    viewModelOf(::DetailsViewModel2)
}
