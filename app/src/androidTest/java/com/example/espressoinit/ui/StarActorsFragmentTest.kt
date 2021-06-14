package com.example.espressoinit.ui

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.espressoinit.R
import com.example.espressoinit.factory.MovieFragmentFactory
import com.example.espressoinit.ui.movie.StarActorsFragment
import org.junit.Test

class StarActorsFragmentTest {


    @Test
    fun test_isDirectorsListVisible() {
        //GIVEN
        val actors = arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        val fragmentFactory = MovieFragmentFactory(null, null)
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", actors)
        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        //Verify
        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    StarActorsFragment.stringBuilderForStarActors(actors)
                )
            )
        )
    }
}