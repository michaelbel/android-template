package org.michaelbel.template.features.githubapi.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class GitHubBaseUrl

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class GitHubOkhttp

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class GitHubRetrofit