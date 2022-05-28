@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation

/**
 * RxJava
 * RxKotlin
 * RxAndroid
 *
 * @see <a href="https://github.com/ReactiveX/RxJava">RxJava</a>
 * @see <a href="https://github.com/ReactiveX/RxKotlin">RxKotlin</a>
 * @see <a href="https://github.com/ReactiveX/RxAndroid">RxAndroid</a>
 */

private const val RxJava3Version = "3.1.4"
private const val RxKotlinVersion = "3.0.1"
private const val RxAndroidVersion = "3.0.0"

private const val RxJava3 = "io.reactivex.rxjava3:rxjava:$RxJava3Version"
private const val RxKotlin = "io.reactivex.rxjava3:rxkotlin:$RxKotlinVersion"
private const val RxAndroid = "io.reactivex.rxjava3:rxandroid:$RxAndroidVersion"

fun DependencyHandler.implementationRxDependencies() {
    implementation(RxJava3)
    implementation(RxKotlin)
    implementation(RxAndroid)
}