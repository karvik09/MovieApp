package com.vikas.movieapp.data.network

import com.vikas.movieapp.data.model.MovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/popular?api_key=38a73d59546aa378980a88b645f487fc")
    suspend fun getMovies(): MovieResponse
}