package com.vikas.movieapp.data.repository.source.remote

import com.vikas.movieapp.data.db.entity.Movie

interface IMovieRemoteSource {
    suspend fun fetchMovies():ArrayList<Movie>
}