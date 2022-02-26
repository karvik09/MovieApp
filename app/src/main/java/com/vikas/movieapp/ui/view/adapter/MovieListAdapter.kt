package com.vikas.movieapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vikas.movieapp.R
import com.vikas.movieapp.data.db.entity.Movie
import com.vikas.movieapp.databinding.MovieItemBinding

class MovieListAdapter : ListAdapter<Movie,MovieListAdapter.MovieVH>(diffUtil) {

    companion object{
        val diffUtil=object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }



    inner class MovieVH(private val binder:MovieItemBinding): RecyclerView.ViewHolder(binder.root){
        fun bind(movie:Movie){
            binder.movie=movie
            binder.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val binder=MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieVH(binder)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.bind(getItem(position))
    }
}