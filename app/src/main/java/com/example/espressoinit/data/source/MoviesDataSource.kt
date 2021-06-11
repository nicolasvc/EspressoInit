package com.codingwithmitch.espressouitestexamples.data.source

import com.example.espressoinit.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}