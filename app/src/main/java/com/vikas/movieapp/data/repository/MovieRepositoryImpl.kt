package com.vikas.movieapp.data.repository

import com.vikas.movieapp.data.db.entity.Movie
import com.vikas.movieapp.data.repository.source.local.IMovieLocalSource
import com.vikas.movieapp.data.repository.source.remote.IMovieRemoteSource
import com.vikas.movieapp.di.annotations.IODispatcher
import com.vikas.movieapp.utils.Failure
import com.vikas.movieapp.utils.Resource
import com.vikas.movieapp.utils.Success
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MovieRepositoryImpl
@Inject constructor(
    private val remoteSource: IMovieRemoteSource,
    private val localSource: IMovieLocalSource,
    @IODispatcher private val ioDispatcher: CoroutineContext
) : IMovieRepository {
    override suspend fun fetchMovies(): Resource<ArrayList<Movie>> {
        return try {
            val local = withContext(ioDispatcher) { localSource.fetchMovies() }
            if (local.isNotEmpty()) {
                Success(body = local)
            }
            val movieList = withContext(ioDispatcher) {
                val remoteMovies = remoteSource.fetchMovies()
                localSource.saveAll(remoteMovies)
                localSource.fetchMovies()
            }
            Success(movieList)
        } catch (e: Exception) {
            Failure()
        }
    }
}