package org.michaelbel.template.features.tmdb_api.model

enum class MoviesList(val sorting: String) {
    NOW_PLAYING("now_playing"),
    POPULAR("popular"),
    TOP_RATED("top_rated"),
    UPCOMING("upcoming")
}