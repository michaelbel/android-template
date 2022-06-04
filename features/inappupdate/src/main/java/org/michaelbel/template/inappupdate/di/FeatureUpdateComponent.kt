package org.michaelbel.template.inappupdate.di

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention
internal annotation class FeatureUpdateScope

class Bar

@DefineComponent(parent = SingletonComponent::class)
internal interface FeatureUpdateComponent

@DefineComponent.Builder
internal interface FeatureUpdateComponentBuilder {
    fun setBar(@BindsInstance bar: Bar): FeatureUpdateComponentBuilder
    fun build(): FeatureUpdateComponent
}

@EntryPoint
@InstallIn(FeatureUpdateComponent::class)
internal interface FeatureUpdateEntryPoint {
    fun getBar(): Bar
}

internal class FeatureUpdateComponentManager @Inject constructor(
    private val componentBuilder: FeatureUpdateComponentBuilder
) {
    fun doSome(value: Bar) {
        val component: FeatureUpdateComponent = componentBuilder.setBar(value).build()
        val entryPoint: FeatureUpdateEntryPoint = EntryPoints.get(component, FeatureUpdateEntryPoint::class.java)
        val bar: Bar = entryPoint.getBar()
    }
}