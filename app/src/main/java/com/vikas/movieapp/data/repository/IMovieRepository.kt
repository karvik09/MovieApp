package com.vikas.movieapp.data.repository

import com.vikas.movieapp.data.db.entity.Movie
import com.vikas.movieapp.utils.Resource

interface IMovieRepository {
    suspend fun fetchMovies(): Resource<ArrayList<Movie>>
}