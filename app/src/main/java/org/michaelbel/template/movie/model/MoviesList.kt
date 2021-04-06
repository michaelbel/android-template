package org.michaelbel.template.movie.model

enum class MoviesList(val sorting: String) {
    NOW_PLAYING("now_playing"),
    POPULAR("popular"),
    TOP_RATED("top_rated"),
    UPCOMING("upcoming")
}