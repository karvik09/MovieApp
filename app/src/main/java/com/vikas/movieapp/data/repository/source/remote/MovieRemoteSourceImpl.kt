package com.vikas.movieapp.data.repository.source.remote

import com.vikas.movieapp.data.db.entity.Movie
import com.vikas.movieapp.data.network.ApiService
import javax.inject.Inject

class MovieRemoteSourceImpl
@Inject constructor(private val apiService: ApiService) : IMovieRemoteSource {

    override suspend fun fetchMovies(): ArrayList<Movie> {
        return apiService.getMovies().results?: arrayListOf()
    }
}