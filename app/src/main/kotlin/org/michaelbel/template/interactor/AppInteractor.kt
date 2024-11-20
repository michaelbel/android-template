package org.michaelbel.template.interactor

import org.michaelbel.core.dispatchers.AppDispatchers
import org.michaelbel.template.repository.AppRepository

class AppInteractor(
    private val appDispatchers: AppDispatchers,
    private val appRepository: AppRepository
)