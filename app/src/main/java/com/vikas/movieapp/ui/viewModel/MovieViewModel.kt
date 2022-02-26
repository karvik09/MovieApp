package com.vikas.movieapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikas.movieapp.data.db.entity.Movie
import com.vikas.movieapp.data.repository.IMovieRepository
import com.vikas.movieapp.utils.Loading
import com.vikas.movieapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel
@Inject constructor(private val repository: IMovieRepository) : ViewModel() {

    private val _fetchMovieLiveData: MutableLiveData<Resource<ArrayList<Movie>>>
            by lazy { MutableLiveData() }

    val movieLiveData: LiveData<Resource<ArrayList<Movie>>>
        get() = _fetchMovieLiveData

    fun fetchMovies() {
        _fetchMovieLiveData.value = Loading()
        viewModelScope.launch {
            val response = repository.fetchMovies()
            _fetchMovieLiveData.value = response
        }
    }
}