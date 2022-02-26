package com.vikas.movieapp.data.repository.source.local

import com.vikas.movieapp.data.db.AppDatabase
import com.vikas.movieapp.data.db.entity.Movie
import javax.inject.Inject

class MovieLocalSourceImpl
@Inject constructor(private val db: AppDatabase) : IMovieLocalSource {
    override fun fetchMovies(): ArrayList<Movie> {
        return ArrayList(db.movieDao().fetchMovies())
    }

    override fun saveAll(movies: ArrayList<Movie>) {
        db.movieDao().insertAll(movies)
    }
}