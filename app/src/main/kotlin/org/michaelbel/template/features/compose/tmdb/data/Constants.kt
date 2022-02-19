package org.michaelbel.template.features.compose.tmdb.data

import java.util.Locale

const val TMDB_API_KEY = "5a24c1bdde77b396b0af765355007f45"
const val TMDB_API_ENDPOINT = "https://api.themoviedb.org/3/"
const val TMDB_IMAGE = "https://image.tmdb.org/t/p/%s/%s"

fun image(path: String, size: String = "original"): String {
    return String.format(Locale.ENGLISH, TMDB_IMAGE, size, path)
}