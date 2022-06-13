@file:Suppress("unused")

package org.michaelbel.core.ktx

fun <T> lazyNone(initializer: () -> T): Lazy<() -> T> {
    return lazy(LazyThreadSafetyMode.NONE) { initializer }
}

fun <T> lazyPublication(initializer: () -> T): Lazy<() -> T> {
    return lazy(LazyThreadSafetyMode.PUBLICATION) { initializer }
}