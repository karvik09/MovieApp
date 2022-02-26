package com.vikas.movieapp.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.vikas.movieapp.R
import com.vikas.movieapp.databinding.ActivityMovieListBinding
import com.vikas.movieapp.ui.view.adapter.MovieListAdapter
import com.vikas.movieapp.ui.viewModel.MovieViewModel
import com.vikas.movieapp.utils.Failure
import com.vikas.movieapp.utils.Loading
import com.vikas.movieapp.utils.Success
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListActivity : AppCompatActivity() {

    @Inject
    lateinit var movieAdapter:MovieListAdapter

    private lateinit var binder: ActivityMovieListBinding
    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)
        initViews()
        observe()
    }

    private fun observe() {
        viewModel.movieLiveData.observe(this, {
            when(it){
                is Loading->{
                    binder.progressBar.visibility=View.VISIBLE
                }
                is Success->{
                    binder.progressBar.visibility=View.GONE
                    movieAdapter.submitList(it.body)
                }
                is Failure->{
                    binder.progressBar.visibility=View.GONE
                    showError()
                }
            }
        })
    }



    private fun showError(){
        Toast.makeText(this,getString(R.string.error_message),Toast.LENGTH_LONG).show()
    }

    private fun initViews() {
        binder.movieList.adapter = movieAdapter
    }
}