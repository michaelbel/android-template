package org.michaelbel.template

import org.michaelbel.core.viewmodel.BaseViewModel
import org.michaelbel.template.repository.AppRepository

class MainViewModel(
    private val appRepository: AppRepository
): BaseViewModel()