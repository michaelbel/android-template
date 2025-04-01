package org.michaelbel.core.ktx

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive

fun JsonElement?.asBoolean(): Boolean {
    return when {
        this == null -> false
        this is JsonPrimitive -> {
            when {
                isString -> content.lowercase() == "true" || content.lowercase() == "1"
                else -> false
            }
        }
        else -> false
    }
}