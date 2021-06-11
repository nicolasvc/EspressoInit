package com.example.espressoinit.navigation

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.espressoinit.MainActivity
import com.example.espressoinit.R
import org.junit.Test

class NavigationTest {

    @Test
    fun testMovieFragmentsNavigation() {
        //Setup
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //Nav Director Fragments
        onView(withId(R.id.movie_directiors)).perform(click())
        //Verify
        onView(withId(R.id.fragment_movie_director_parent)).check(matches(isDisplayed()))

        pressBack()

        //Verify
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))
        //Nav starActor
        onView(withId(R.id.movie_star_actors)).perform(click())

        onView(withId(R.id.fragment_movie_actors_parent)).check(matches(isDisplayed()))






    }
}