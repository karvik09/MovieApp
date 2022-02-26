package com.vikas.movieapp.utils

sealed interface Resource<T>
data class Success<T>(val body: T?) : Resource<T>
class Loading<T> : Resource<T>
class Failure<T> : Resource<T>