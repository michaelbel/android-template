@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.lifecycle.SavedStateHandle

fun <T> SavedStateHandle.require(key: String): T = requireNotNull(this[key])