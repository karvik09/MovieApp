package com.vikas.movieapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vikas.movieapp.data.db.entity.Movie
import com.vikas.movieapp.data.db.entity.Playlist

@Dao
interface PlaylistDao {

    @Query("SELECT * FROM playlist")
    fun fetchPlaylist():List<Playlist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(meme: List<Playlist>)
}