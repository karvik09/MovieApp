package com.vikas.movieapp.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.vikas.movieapp.R
import com.vikas.movieapp.constant.AppConstant
import com.vikas.movieapp.data.db.entity.Movie

@BindingAdapter("url", "placeholder")
fun ImageView.loadImage(url: String, placeholder: Int) {
    load(url) {
        crossfade(true)
        placeholder(placeholder)
        error(placeholder)
    }
}

private val i = R.mipmap.ic_launcher

@BindingAdapter("thumbnail")
fun ImageView.setThumbnail(movie:Movie){
    val imageUrl=AppConstant.POSTER_BASE_PATH+movie.posterPath
    this.loadImage(imageUrl,R.mipmap.ic_launcher)
}