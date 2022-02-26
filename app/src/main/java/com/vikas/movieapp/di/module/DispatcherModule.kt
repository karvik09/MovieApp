package com.vikas.movieapp.di.module

import com.vikas.movieapp.di.annotations.DefaultDispatcher
import com.vikas.movieapp.di.annotations.IODispatcher
import com.vikas.movieapp.di.annotations.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher() = Dispatchers.Default

    @Provides
    @MainDispatcher
    fun provideMainDispatcher() = Dispatchers.Main
}