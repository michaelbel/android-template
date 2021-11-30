package org.michaelbel.core.model

import android.view.View

typealias OnClick = (view: View) -> Unit
typealias OnLongClick = (view: View) -> Boolean
typealias StringUnit = (it: String) -> Unit
typealias BooleanUnit = (it: Boolean) -> Unit