@file:Suppress("unused")

package org.michaelbel.core.ktx

fun <T> lazyUnsafe(initializer: () -> T): Lazy<() -> T> {
    return lazy(LazyThreadSafetyMode.NONE) { initializer }
}