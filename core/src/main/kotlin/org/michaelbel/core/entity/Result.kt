@file:Suppress("unused")

package org.michaelbel.core.entity

sealed class Result<out A: Any, out B: Any> {
    data class Success<A: Any>(val value: A): Result<A, Nothing>()
    data class Failure<B: Any>(val error: B): Result<Nothing, B>()
}