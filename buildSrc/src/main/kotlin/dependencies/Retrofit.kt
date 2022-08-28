@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * Retrofit
 *
 * @see <a href="https://github.com/square/retrofit">Retrofit</a>
 * @see <a href="https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter">Kotlin Serialization Converter</a>
 * @see <a href="https://github.com/square/okhttp">Okhttp</a>
 */

private const val RetrofitVersion = "2.9.0"
private const val RetrofitConverterSerializationVersion = "0.8.0"

private const val OkhttpLoggingInterceptorVersion = "5.0.0-alpha.2"

private const val Retrofit = "com.squareup.retrofit2:retrofit:$RetrofitVersion"
private const val RetrofitConverterGson = "com.squareup.retrofit2:converter-gson:$RetrofitVersion"
private const val RetrofitConverterSerialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$RetrofitConverterSerializationVersion"
private const val RetrofitAdapterRxjava = "com.squareup.retrofit2:adapter-rxjava2:$RetrofitVersion"

private const val OkhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$OkhttpLoggingInterceptorVersion"

fun DependencyHandler.implementationRetrofitDependencies() {
    implementation(Retrofit)
    implementation(RetrofitConverterSerialization)
    implementation(OkhttpLoggingInterceptor)
}

fun DependencyHandler.apiRetrofitDependencies() {
    api(Retrofit)
    api(RetrofitConverterSerialization)
    api(OkhttpLoggingInterceptor)
}