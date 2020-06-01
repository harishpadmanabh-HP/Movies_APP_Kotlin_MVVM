package com.harish.moviemvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.harish.moviemvvm.data.api.TheMovieDBInterface
import com.harish.moviemvvm.data.repository.MovieDetailsNetworkDataSource
import com.harish.moviemvvm.data.repository.NetworkState
import com.harish.moviemvvm.data.models.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}