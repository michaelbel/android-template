@file:Suppress("unused")

package org.michaelbel.core.ktx

inline val Int.toHexColor: String
    get() = String.format("#%06X", 0xFFFFFF and this)