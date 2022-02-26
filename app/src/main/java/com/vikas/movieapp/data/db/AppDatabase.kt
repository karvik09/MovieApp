package com.vikas.movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vikas.movieapp.data.db.dao.MovieDao
import com.vikas.movieapp.data.db.dao.PlaylistDao
import com.vikas.movieapp.data.db.entity.Movie
import com.vikas.movieapp.data.db.entity.Playlist

@Database(entities = [Movie::class,Playlist::class], version = AppDatabase.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object{
        const val DB_NAME = "imdb.db"
        const val DB_VERSION = 1
    }
    abstract fun movieDao(): MovieDao
    abstract fun playlistDao():PlaylistDao
}