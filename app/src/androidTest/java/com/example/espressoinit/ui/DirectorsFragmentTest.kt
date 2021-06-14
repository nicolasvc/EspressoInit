package com.example.espressoinit.ui

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.espressoinit.R
import com.example.espressoinit.factory.MovieFragmentFactory
import com.example.espressoinit.ui.movie.DirectorsFragment
import org.junit.Test

class DirectorsFragmentTest {
    @Test
    fun test_isDirectorsListVisible() {
        //GIVEN
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory(null, null)
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", directors)
        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        //Verify
        onView(withId(R.id.directors_text)).check(matches(withText(DirectorsFragment.stringBuilderForDirectors(directors))))
    }
}