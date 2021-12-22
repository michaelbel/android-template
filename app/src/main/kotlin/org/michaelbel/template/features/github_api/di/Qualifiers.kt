package org.michaelbel.template.features.github_api.di

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