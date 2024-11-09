package org.michaelbel.template

import org.michaelbel.core.viewmodel.BaseViewModel
import org.michaelbel.template.datastore.AppPreferences

class MainViewModel(
    private val appPreferences: AppPreferences
): BaseViewModel()