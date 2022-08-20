@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.api
import org.michaelbel.template.extensions.ksp
import org.michaelbel.template.extensions.testApi
import org.michaelbel.template.extensions.implementation
import org.michaelbel.template.extensions.testImplementation

/**
 * Room
 *
 * @see <a href="https://developer.android.com/jetpack/androidx/releases/room">Room</a>
 */

private const val RoomVersion = "2.4.3"

private const val Room = "androidx.room:room-ktx:$RoomVersion"
private const val RoomCompiler = "androidx.room:room-compiler:$RoomVersion"
private const val RoomPaging = "androidx.room:room-paging:$RoomVersion"
private const val RoomRuntime = "androidx.room:room-runtime:$RoomVersion"
private const val RoomTesting = "androidx.room:room-testing:$RoomVersion"

fun DependencyHandler.implementationRoomDependencies() {
    implementation(Room)
    implementation(RoomPaging)
    implementation(RoomRuntime)
    ksp(RoomCompiler)
    testImplementation(RoomTesting)
}

fun DependencyHandler.apiRoomDependencies() {
    api(Room)
    api(RoomPaging)
    api(RoomRuntime)
    ksp(RoomCompiler)
    testApi(RoomTesting)
}