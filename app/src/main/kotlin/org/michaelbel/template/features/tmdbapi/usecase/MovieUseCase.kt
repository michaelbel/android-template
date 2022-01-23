package org.michaelbel.template.features.tmdbapi.usecase

import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import org.michaelbel.core.di.qualifiers.IoDispatcher
import org.michaelbel.core.usecase.UseCase
import org.michaelbel.template.features.tmdbapi.domain.MovieRepository
import org.michaelbel.template.features.tmdbapi.model.moshi.Movie2

class MovieUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val movieRepository: MovieRepository
): UseCase<MovieUseCase.Params, Movie2>(dispatcher) {

    override suspend fun execute(parameters: Params): Movie2 {
        return movieRepository.movie(
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