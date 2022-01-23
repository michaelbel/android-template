package org.michaelbel.template.features.githubapi.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import org.michaelbel.template.features.githubapi.api.GithubService
import org.michaelbel.template.features.githubapi.db.RepoDatabase
import org.michaelbel.template.features.githubapi.model.Repo

/**
 * Repository class that works with local and remote data sources.
 */
class GithubRepository @Inject constructor(
    private val service: GithubService,
    private val database: RepoDatabase
) {

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */
    fun getSearchResultStream(query: String): Flow<PagingData<Repo>> {
        // appending '%' so we can allow other characters to be before and after the query string
        val dbQuery = "%${query.replace(' ', '%')}%"
        val pagingSourceFactory = { database.reposDao.reposByName(dbQuery) }

        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = GithubRemoteMediator(
                query,
                service,
                database
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    private companion object {
        private const val NETWORK_PAGE_SIZE = 10
    }
}