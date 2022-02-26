package com.vikas.movieapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vikas.movieapp.data.db.entity.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun fetchMovies():List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(meme: List<Movie>)
}