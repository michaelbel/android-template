package org.michaelbel.template.ui.details2.intent

import org.michaelbel.shared.mvi.Intent

sealed class Details2Intent: Intent {
    data object CollectData: Details2Intent()
    data class SetId(val id: Int): Details2Intent()
}