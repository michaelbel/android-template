@file:Suppress("unused")

package org.michaelbel.core.ktx

inline val <K, V> Map<out K, V>.firstKey: K
    get() = entries.first().key

inline val <K, V> Map<out K, V>.firstValue: V
    get() = entries.first().value

inline val <K, V> Map<out K, V>.firstKeyOrNull: K?
    get() = entries.firstOrNull()?.key

inline val <K, V> Map<out K, V>.firstValueOrNull: V?
    get() = entries.firstOrNull()?.value

fun <K, V> Map<K, V>.getOrDefaultKTX(key: K, defaultValue: V): V {
    return get(key) ?: defaultValue
}