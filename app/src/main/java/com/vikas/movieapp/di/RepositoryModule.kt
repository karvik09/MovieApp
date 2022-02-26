package com.vikas.movieapp.di

import com.vikas.movieapp.data.repository.IMovieRepository
import com.vikas.movieapp.data.repository.MovieRepositoryImpl
import com.vikas.movieapp.data.repository.source.local.IMovieLocalSource
import com.vikas.movieapp.data.repository.source.local.MovieLocalSourceImpl
import com.vikas.movieapp.data.repository.source.remote.IMovieRemoteSource
import com.vikas.movieapp.data.repository.source.remote.MovieRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(
        repository: MovieRepositoryImpl
    ): IMovieRepository

    @Singleton
    @Binds
    abstract fun bindNetworkSource(
        source: MovieRemoteSourceImpl
    ): IMovieRemoteSource

    @Singleton
    @Binds
    abstract fun bindDatabaseSource(
        source: MovieLocalSourceImpl
    ): IMovieLocalSource
}