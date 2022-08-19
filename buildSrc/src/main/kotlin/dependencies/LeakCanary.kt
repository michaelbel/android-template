@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.debugImplementation

/**
 * LeakCanary
 *
 * @see <a href="https://github.com/square/leakcanary">LeakCanary</a>
 * @see <a href="https://mvnrepository.com/artifact/com.squareup.leakcanary">Maven</a>
 */

private const val LeakCanaryVersion = "2.9.1"

private const val LeakCanaryAndroid = "com.squareup.leakcanary:leakcanary-android:$LeakCanaryVersion"
private const val LeakCanaryAndroidCore = "com.squareup.leakcanary:leakcanary-android-core:$LeakCanaryVersion"
private const val LeakCanaryAndroidProcess = "com.squareup.leakcanary:leakcanary-android-process:$LeakCanaryVersion"
private const val LeakCanaryAndroidRelease = "com.squareup.leakcanary:leakcanary-android-release:$LeakCanaryVersion"
private const val LeakCanaryAndroidStartup = "com.squareup.leakcanary:leakcanary-android-startup:$LeakCanaryVersion"
private const val LeakCanaryAndroidUtils = "com.squareup.leakcanary:leakcanary-android-utils:$LeakCanaryVersion"

private const val LeakCanaryObjectWatcher = "com.squareup.leakcanary:leakcanary-object-watcher:$LeakCanaryVersion"
private const val LeakCanaryObjectWatcherAndroid = "com.squareup.leakcanary:leakcanary-object-watcher-android:$LeakCanaryVersion"
private const val LeakCanaryObjectWatcherAndroidCore = "com.squareup.leakcanary:leakcanary-object-watcher-android-core:$LeakCanaryVersion"
private const val LeakCanaryObjectWatcherAndroidx = "com.squareup.leakcanary:leakcanary-object-watcher-android-androidx:$LeakCanaryVersion"
private const val LeakCanaryObjectWatcherAndroidStartup = "com.squareup.leakcanary:leakcanary-object-watcher-android-startup:$LeakCanaryVersion"
private const val LeakCanaryObjectWatcherFragments = "com.squareup.leakcanary:leakcanary-object-watcher-android-support-fragments:$LeakCanaryVersion"

private const val LeakCanaryPlumberAndroid = "com.squareup.leakcanary:plumber-android:$LeakCanaryVersion"
private const val LeakCanaryPlumberAndroidCore = "com.squareup.leakcanary:plumber-android-core:$LeakCanaryVersion"
private const val LeakCanaryPlumberAndroidStartup = "com.squareup.leakcanary:plumber-android-startup:$LeakCanaryVersion"

private const val LeakCanaryShark = "com.squareup.leakcanary:shark:$LeakCanaryVersion"
private const val LeakCanarySharkAndroid = "com.squareup.leakcanary:shark-android:$LeakCanaryVersion"
private const val LeakCanarySharkCli = "com.squareup.leakcanary:shark-cli:$LeakCanaryVersion"
private const val LeakCanarySharkGraph = "com.squareup.leakcanary:shark-graph:$LeakCanaryVersion"
private const val LeakCanarySharkHprof = "com.squareup.leakcanary:shark-hprof:$LeakCanaryVersion"
private const val LeakCanarySharkLog = "com.squareup.leakcanary:shark-log:$LeakCanaryVersion"

fun DependencyHandler.implementationLeakCanaryDependencies() {
    debugImplementation(LeakCanaryAndroid)
}