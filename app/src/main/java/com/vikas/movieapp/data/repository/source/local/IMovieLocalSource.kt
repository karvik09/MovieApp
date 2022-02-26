package com.vikas.movieapp.data.repository.source.local

import com.vikas.movieapp.data.db.entity.Movie

interface IMovieLocalSource {
    fun fetchMovies(): ArrayList<Movie>
    fun saveAll(movies: ArrayList<Movie>)
}