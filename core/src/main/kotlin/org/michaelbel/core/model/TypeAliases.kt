@file:Suppress("unused")

package org.michaelbel.core.model

import android.view.View

typealias OnClick = (view: View) -> Unit
typealias OnLongClick = (view: View) -> Boolean
typealias IntUnit = (it: Int) -> Unit
typealias LongUnit = (it: Long) -> Unit
typealias FloatUnit = (it: Float) -> Unit
typealias StringUnit = (it: String) -> Unit
typealias BooleanUnit = (it: Boolean) -> Unit