package org.michaelbel.core.di.qualifiers

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ConverterFactoryGson

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ConverterFactoryMoshi

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ConverterFactorySerialization