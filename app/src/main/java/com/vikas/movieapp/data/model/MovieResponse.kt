package com.vikas.movieapp.data.model

import com.google.gson.annotations.SerializedName
import com.vikas.movieapp.data.db.entity.Movie

data class MovieResponse (
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: ArrayList<Movie>?
)