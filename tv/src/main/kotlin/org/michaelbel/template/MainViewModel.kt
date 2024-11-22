package org.michaelbel.template

import org.michaelbel.core.viewmodel.BaseViewModel
import org.michaelbel.template.interactor.AppInteractor

class MainViewModel(
    private val appInteractor: AppInteractor
): BaseViewModel()