package com.example.espressoinit.ui

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.example.espressoinit.R
import com.example.espressoinit.data.Movie
import com.example.espressoinit.factory.MovieFragmentFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test

class MovieDetailFragmentTest {

    @Test
    fun test_isMovieDataVisible() {
        // SETUP
        val movieId = 1
        val title = "The Rundown"
        val description =
            "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                    "becomes involved in the fight against an oppressive town operator and the search " +
                    "for a legendary treasure."
        //Create a object Movie
        val movie = Movie(
            movieId,
            title,
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
            description,
            arrayListOf("R.J. Stewart", "James Vanderbilt"),
            arrayListOf(
                "Dwayne Johnson",
                "Seann William Scott",
                "Rosario Dawson",
                "Christopher Walken"
            )
        )

        //Create the mock
        val moviesDataSource = mockk<MoviesDataSource>()
        every {
            moviesDataSource.getMovie(movieId)
        } returns movie

        val requestOptions = RequestOptions().placeholder(R.drawable.default_image).error(R.drawable.default_image)
        val fragmentFactory = MovieFragmentFactory(requestOptions,moviesDataSource)
        val bundle = Bundle()
        bundle.putInt("movie_id",movieId)
        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //verify
        onView(withId(R.id.movie_title)).check(matches(withText(title)))

        onView(withId(R.id.movie_description)).check(matches(withText(description)))


    }
}