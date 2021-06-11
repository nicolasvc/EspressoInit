package com.example.espressoinit.testfragment

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressoinit.DirectorsFragment
import com.example.espressoinit.R
import com.example.espressoinit.data.Movie
import com.example.espressoinit.factory.MovieFragmentFactory
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest {

    @Test
    fun test_IsDirectorListVisible() {
        //Preparar la información
        val directors =  arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors",directors)

        //Scenario
        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //Test
        onView(withId(R.id.directors_text)).check(matches(withText(
            DirectorsFragment.stringBuilderForDirectors(directors))))


    }
}