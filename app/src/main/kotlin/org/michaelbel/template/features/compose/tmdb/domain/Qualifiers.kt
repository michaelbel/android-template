package org.michaelbel.template.features.compose.tmdb.domain

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class TmdbBaseUrl

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class TmdbOkhttp

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class TmdbRetrofit