@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.implementation

/**
 * Okhttp
 *
 * @see <a href="https://github.com/square/okhttp">Okhttp</a>
 */

private const val OkhttpVersion = "4.10.0"

private const val Okhttp = "com.squareup.okhttp3:okhttp:$OkhttpVersion"
private const val OkhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$OkhttpVersion"

fun DependencyHandler.implementationOkhttpDependencies() {
    implementation(OkhttpLoggingInterceptor)
}

fun DependencyHandler.apiOkhttpDependencies() {
    api(OkhttpLoggingInterceptor)
}