@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    compilerOptions {
        jvmToolchain(libs.versions.jdk.get().toInt())
    }
}

android {
    namespace = "org.michaelbel.template.core"

    defaultConfig {
        compileSdk = libs.versions.compile.sdk.get().toInt()
        minSdk = libs.versions.min.sdk.get().toInt()
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    api(libs.kotlin.reflect)
    api(libs.kotlin.test)
    api(libs.kotlin.test.junit)
    api(libs.kotlinx.coroutines.core)
    api(libs.kotlinx.coroutines.android)
    api(libs.kotlinx.coroutines.play.services)
    api(libs.kotlinx.coroutines.test)
    api(libs.kotlinx.datetime)
    api(libs.kotlinx.serialization.json)
    api(libs.kotlinx.serialization.cbor)
    api(libs.kotlinx.serialization.properties)
    api(libs.kotlinx.serialization.hocon)
    api(libs.kotlinx.io)
    api(libs.kotlinx.collections.immutable)
    api(libs.kotlinx.atomicfu)

    //api(libs.google.gms.play.services.ads) need manifest params

    //api(libs.google.services.base)
    //api(libs.google.services.instantapps)
    //api(libs.google.play.asset.delivery.ktx)
    //api(libs.google.play.delivery.ktx)
    //api(libs.google.play.review.ktx)
    //api(libs.google.play.app.update.ktx)
    api(libs.google.material)
    api(libs.google.material.compose.theme.adapter)
    api(libs.google.firebase.analytics.ktx)
    api(libs.google.firebase.config.ktx)
    api(libs.google.firebase.crashlytics.ktx)
    api(libs.google.firebase.messaging.ktx)

    api(libs.androidx.activity.ktx)
    api(libs.androidx.activity.compose)
    api(libs.androidx.ads.identifier)
    api(libs.androidx.ads.identifier.provider)
    api(libs.androidx.annotation)
    api(libs.androidx.annotation.experimental)
    api(libs.androidx.appcompat)
    api(libs.androidx.appcompat.resources)
    api(libs.androidx.appsearch)
    ksp(libs.androidx.appsearch.compiler)
    api(libs.androidx.appsearch.local.storage)
    api(libs.androidx.appsearch.platform.storage)
    api(libs.androidx.arch.core.common)
    api(libs.androidx.arch.core.runtime)
    api(libs.androidx.arch.core.testing)
    api(libs.androidx.asynclayoutinflater)
    api(libs.androidx.autofill)
    api(libs.androidx.benchmark.junit4)
    api(libs.androidx.benchmark.macro.junit4)
    api(libs.androidx.biometric.ktx)
    api(libs.androidx.bluetooth)
    //api(libs.androidx.bluetooth.testing) min sdk 33
    api(libs.androidx.browser)
    api(libs.androidx.car.app)
    api(libs.androidx.car.app.automotive)
    api(libs.androidx.car.app.testing)
    api(libs.androidx.camera.core)
    api(libs.androidx.camera.camera2)
    api(libs.androidx.camera.lifecycle)
    api(libs.androidx.camera.video)
    api(libs.androidx.camera.view)
    api(libs.androidx.camera.mlkit.vision)
    api(libs.androidx.camera.extensions)
    api(libs.androidx.camera.effects)
    api(libs.androidx.camera.viewfinder)
    api(libs.androidx.camera.viewfinder.core)
    api(libs.androidx.camera.viewfinder.compose)
    api(libs.androidx.cardview)
    api(libs.androidx.collection)
    api(libs.androidx.compose.animation)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.material.icons.extended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.androidx.compose.material3.adaptive.layout)
    api(libs.androidx.compose.material3.adaptive.navigation)
    api(libs.androidx.compose.material3.adaptive.navigation.suite)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.test.junit4)
    api(libs.androidx.compose.ui.test.manifest)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.concurrent.futures.ktx)
    api(libs.androidx.constraintlayout)
    api(libs.androidx.constraintlayout.compose)
    api(libs.androidx.contentpager)
    api(libs.androidx.coordinatorlayout)
    api(libs.androidx.core.ktx)
    api(libs.androidx.core.animation)
    api(libs.androidx.core.animation.testing)
    api(libs.androidx.core.google.shortcuts)
    api(libs.androidx.core.performance)
    api(libs.androidx.core.remoteviews)
    api(libs.androidx.core.role)
    api(libs.androidx.core.splashscreen)
    api(libs.androidx.core.location.altitude)
    api(libs.androidx.core.location.altitude.external.protobuf)
    api(libs.androidx.core.location.altitude.proto)
    api(libs.androidx.core.i18n)
    api(libs.androidx.core.telecom)
    api(libs.androidx.core.uwb)
    api(libs.androidx.credentials)
    api(libs.androidx.credentials.play.services.auth)
    api(libs.androidx.credentials.e2ee)
    api(libs.androidx.cursoradapter)
    api(libs.androidx.customview)
    api(libs.androidx.customview.poolingcontainer)
    api(libs.androidx.datastore)
    api(libs.androidx.datastore.core)
    api(libs.androidx.datastore.preferences)
    api(libs.androidx.datastore.preferences.core)
    api(libs.androidx.documentfile)
    api(libs.androidx.draganddrop)
    api(libs.androidx.drawerlayout)
    api(libs.androidx.dynamicanimation)
    api(libs.androidx.emoji)
    api(libs.androidx.emoji.appcompat)
    api(libs.androidx.emoji.bundled)
    api(libs.androidx.emoji2)
    api(libs.androidx.emoji2.views)
    api(libs.androidx.emoji2.emojipicker)
    api(libs.androidx.enterprise.feedback)
    api(libs.androidx.enterprise.feedback.testing)
    api(libs.androidx.exifinterface)
    api(libs.androidx.fragment.ktx)
    api(libs.androidx.fragment.compose)
    api(libs.androidx.fragment.testing)
    //api(libs.androidx.games.activity) duplicate class
    api(libs.androidx.games.controller)
    api(libs.androidx.games.frame.pacing)
    api(libs.androidx.games.memory.advice)
    api(libs.androidx.games.performance.tuner)
    api(libs.androidx.games.text.input)
    api(libs.androidx.glance)
    api(libs.androidx.glance.appwidget)
    api(libs.androidx.glance.appwidget.external.protobuf)
    api(libs.androidx.glance.appwidget.preview)
    api(libs.androidx.glance.appwidget.proto)
    api(libs.androidx.glance.appwidget.testing)
    api(libs.androidx.glance.material)
    api(libs.androidx.glance.material3)
    api(libs.androidx.glance.preview)
    api(libs.androidx.glance.testing)
    api(libs.androidx.glance.wear.tiles)
    api(libs.androidx.graphics.core)
    api(libs.androidx.graphics.path)
    api(libs.androidx.graphics.shapes)
    api(libs.androidx.gridlayout)
    api(libs.androidx.health.services.client)
    api(libs.androidx.health.connect.client)
    api(libs.androidx.heifwriter)
    api(libs.androidx.hilt.common)
    ksp(libs.androidx.hilt.compiler)
    api(libs.androidx.hilt.lifecycle.viewmodel)
    api(libs.androidx.hilt.navigation)
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.hilt.navigation.fragment)
    api(libs.androidx.hilt.work)
    api(libs.androidx.input.motionprediction)
    api(libs.androidx.interpolator)
    api(libs.androidx.javascriptengine)
    api(libs.androidx.leanback)
    api(libs.androidx.leanback.preference)
    api(libs.androidx.leanback.paging)
    api(libs.androidx.leanback.grid)
    api(libs.androidx.leanback.tab)
    api(libs.androidx.lifecycle.runtime)
    api(libs.androidx.lifecycle.livedata)
    api(libs.androidx.lifecycle.livedata.core.ktx)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.lifecycle.viewmodel.compose)
    api(libs.androidx.lifecycle.service)
    api(libs.androidx.lifecycle.process)
    api(libs.androidx.lifecycle.reactivestreams.ktx)
    api(libs.androidx.lifecycle.runtime.compose)
    lintChecks(libs.androidx.lint.checks)
    //api(libs.androidx.lint.api) not found
    //api(libs.androidx.lint.core) not found
    //api(libs.androidx.lint.annotations) not found
    lintChecks(libs.androidx.lint.gradle)
    api(libs.androidx.loader.loader)
    //api(libs.androidx.loader.loader.testing)
    api(libs.androidx.localbroadcastmanager)
    api(libs.androidx.media3.exoplayer)
    api(libs.androidx.media3.exoplayer.dash)
    api(libs.androidx.media3.exoplayer.hls)
    api(libs.androidx.media3.exoplayer.smoothstreaming)
    api(libs.androidx.media3.exoplayer.rtsp)
    //api(libs.androidx.media3.exoplayer.midi)
    api(libs.androidx.media3.exoplayer.ima)
    api(libs.androidx.media3.datasource.cronet)
    api(libs.androidx.media3.datasource.okhttp)
    api(libs.androidx.media3.datasource.rtmp)
    api(libs.androidx.media3.ui)
    api(libs.androidx.media3.ui.leanback)
    api(libs.androidx.media3.session)
    api(libs.androidx.media3.extractor)
    api(libs.androidx.media3.cast)
    api(libs.androidx.media3.exoplayer.workmanager)
    api(libs.androidx.media3.transformer)
    api(libs.androidx.media3.effect)
    api(libs.androidx.media3.muxer)
    api(libs.androidx.media3.test.utils)
    api(libs.androidx.media3.test.utils.robolectric)
    api(libs.androidx.media3.container)
    api(libs.androidx.media3.database)
    api(libs.androidx.media3.decoder)
    api(libs.androidx.media3.datasource)
    api(libs.androidx.media3.common)
    api(libs.androidx.mediarouter)
    api(libs.androidx.metrics)
    api(libs.androidx.navigation.compose)
    api(libs.androidx.navigation.fragment.ktx)
    api(libs.androidx.navigation.fragment.compose)
    api(libs.androidx.navigation.runtime.ktx)
    api(libs.androidx.navigation.ui.ktx)
    api(libs.androidx.navigation.common)
    api(libs.androidx.navigation.testing)
    api(libs.androidx.navigation.dynamic.features.fragment)
    api(libs.androidx.paging.rxjava2)
    api(libs.androidx.paging.rxjava3)
    api(libs.androidx.paging.compose)
    api(libs.androidx.paging.common.ktx)
    api(libs.androidx.paging.runtime.ktx)
    api(libs.androidx.palette.ktx)
    //api(libs.androidx.pdf.viewer) minSdkVersion 35
    //api(libs.androidx.pdf.viewer.fragment) minSdkVersion 35
    api(libs.androidx.percentlayout)
    api(libs.androidx.preference.ktx)
    api(libs.androidx.print)
    api(libs.androidx.profileinstaller)
    api(libs.androidx.recommendation)
    api(libs.androidx.recyclerview)
    api(libs.androidx.recyclerview.selection)
    api(libs.androidx.remotecallback)
    api(libs.androidx.resourceinspection.annotation)
    api(libs.androidx.room.ktx)
    api(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    api(libs.androidx.room.paging)
    api(libs.androidx.room.testing)
    api(libs.androidx.savedstate.ktx)
    api(libs.androidx.security.crypto.ktx)
    api(libs.androidx.security.app.authenticator)
    api(libs.androidx.security.app.authenticator.testing)
    ///api(libs.androidx.security.identity.credential)
    api(libs.androidx.security.state)
    api(libs.androidx.sharetarget)
    api(libs.androidx.slice.core)
    api(libs.androidx.slice.builders.ktx)
    api(libs.androidx.slice.view)
    api(libs.androidx.slidingpanelayout)
    api(libs.androidx.sqlite.ktx)
    api(libs.androidx.sqlite.framework)
    api(libs.androidx.startup.runtime)
    api(libs.androidx.swiperefreshlayout)
    api(libs.androidx.test.core.ktx)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.espresso.idling.resource)
    //api(libs.androidx.espresso.test.espresso.contrib)
    //api(libs.androidx.test.espresso.device)
    api(libs.androidx.test.ext.junit.ktx)
    api(libs.androidx.test.ext.junit.gtest)
    api(libs.androidx.test.ext.truth)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.orchestrator)
    api(libs.androidx.test.annotation)
    api(libs.androidx.test.monitor)
    api(libs.androidx.test.services.storage)
    api(libs.androidx.test.services.test.services)
    api(libs.androidx.test.uiautomator)
    api(libs.androidx.textclassifier)
    api(libs.androidx.tracing)
    api(libs.androidx.transition.ktx)
    api(libs.androidx.tv.foundation)
    api(libs.androidx.tv.material)
    api(libs.androidx.tvprovider)
    api(libs.androidx.vectordrawable)
    api(libs.androidx.vectordrawable.animated)
    api(libs.androidx.vectordrawable.seekable)
    api(libs.androidx.versionedparcelable)
    api(libs.androidx.viewpager)
    api(libs.androidx.viewpager2)
    api(libs.androidx.wear)
    //api(libs.androidx.wear.complications.data.source.ktx)
    //api(libs.androidx.wear.complications.provider)
    //api(libs.androidx.wear.core)
    //api(libs.androidx.wear.tiles)
    //api(libs.androidx.wear.tiles.proto)
    //api(libs.androidx.wear.tiles.renderer)
    //api(libs.androidx.wear.tooling.preview)
    //api(libs.androidx.wear.watchface)
    //api(libs.androidx.wear.watchface.client)
    //api(libs.androidx.wear.watchface.data)
    //api(libs.androidx.wear.watchface.editor)
    //api(libs.androidx.wear.watchface.complications.rendering)
    //api(libs.androidx.wear.watchface.style)
    api(libs.androidx.wear.input)
    api(libs.androidx.wear.input.testing)
    api(libs.androidx.wear.ongoing)
    api(libs.androidx.wear.phone.interactions)
    api(libs.androidx.wear.remote.interactions)
    api(libs.androidx.wear.compose.foundation)
    api(libs.androidx.wear.compose.material)
    api(libs.androidx.wear.compose.material.core)
    api(libs.androidx.wear.compose.material3)
    api(libs.androidx.wear.compose.navigation)
    api(libs.androidx.wear.compose.ui.tooling)
    api(libs.androidx.wear.protolayout)
    api(libs.androidx.wear.protolayout.expression)
    api(libs.androidx.wear.protolayout.expression.pipeline)
    api(libs.androidx.wear.protolayout.external.protobuf)
    api(libs.androidx.wear.protolayout.material)
    api(libs.androidx.wear.protolayout.material.core)
    api(libs.androidx.wear.protolayout.proto)
    api(libs.androidx.wear.protolayout.renderer)
    api(libs.androidx.wear.tiles.tiles)
    api(libs.androidx.wear.tiles.tiles.material)
    api(libs.androidx.wear.tiles.tiles.proto)
    api(libs.androidx.wear.tiles.tiles.renderer)
    api(libs.androidx.wear.tiles.tiles.testing)
    api(libs.androidx.wear.tiles.tiles.tooling)
    api(libs.androidx.wear.tiles.tiles.tooling.preview)
    api(libs.androidx.wear.watchface.watchface)
    api(libs.androidx.wear.watchface.watchface.client)
    api(libs.androidx.wear.watchface.complications)
    api(libs.androidx.wear.watchface.complications.data)
    api(libs.androidx.wear.watchface.complications.data.source.ktx)
    api(libs.androidx.wear.watchface.watchface.complications.rendering)
    api(libs.androidx.wear.watchface.watchface.data)
    api(libs.androidx.wear.watchface.watchface.editor)
    api(libs.androidx.wear.watchface.watchface.style)
    api(libs.androidx.webkit)
    api(libs.androidx.window)
    api(libs.androidx.window.core)
    api(libs.androidx.window.testing)
    api(libs.androidx.window.extensions.core)
    api(libs.androidx.work.testing)
    api(libs.androidx.work.runtime.ktx)
    api(libs.androidx.work.multiprocess)
    api(libs.androidx.work.gcm)
}