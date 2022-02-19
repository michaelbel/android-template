package org.michaelbel.template.features.compose.tmdb.domain

import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import org.michaelbel.core.coroutines.IoDispatcher
import org.michaelbel.core.usecase.UseCase
import org.michaelbel.template.features.compose.tmdb.data.Movie

class MovieUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val moviesRepository: MoviesRepository
): UseCase<MovieUseCase.Params, Movie>(dispatcher) {

    override suspend fun execute(parameters: Params): Movie {
        return moviesRepository.movie(
            movieId = parameters.movieId,
            apiKey = parameters.apiKey,
            language = parameters.language,
            addToResponse = parameters.addToResponse
        )
    }

    data class Params(
        val movieId: Long,
        val apiKey: String,
        val language: String,
        val addToResponse: String
    )
}