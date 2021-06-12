package com.example.espressoinit.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.codingwithmitch.espressouitestexamples.data.DummyMovies
import com.example.espressoinit.R
import com.example.espressoinit.ui.MoviesListAdapter.MovieViewHolder
import org.junit.Rule
import org.junit.Test

class MovieListFragmentTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val LIST_ITEM_IN_TEST = 4
    val MOVIE_IN_TEST =  DummyMovies.movies[LIST_ITEM_IN_TEST]

    /**
     * Recycler view comes to view
     * */
    @Test
    fun test_validar_recyclerIsInView() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /*
     * Select list item , nav to Detail fragment , correct movie is in view?
     * */
    @Test
    fun test_selectedListItem_isDetailFragmentVisible() {
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<MovieViewHolder>(LIST_ITEM_IN_TEST,click()))
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))
    }
    /**
     * Select list item , nav to DetailFragment
     * Press back
     * */
    @Test
    fun test_backNavigation_toMovieListFragment() {
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<MovieViewHolder>(LIST_ITEM_IN_TEST,click()))
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))
        pressBack()
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /*
    *  Select list item nav to detail then select directors and nav to director fragment
    * */
    @Test
    fun test_nav_directors_fragments_validate_director_list() {
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<MovieViewHolder>(LIST_ITEM_IN_TEST,click()))
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))

        onView(withId(R.id.movie_directiors)).perform(click())
        val directors = MOVIE_IN_TEST.directors
        val verifyDirector = DirectorsFragment.stringBuilderForDirectors(directors!!)
        onView(withId(R.id.directors_text)).check(matches(withText(verifyDirector)))
    }
    /*
    *  Select list item nav to detail then select actors and nav to actor fragment
    * */

    @Test
    fun test_nav_actor_fragments_validate_actors_list() {
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<MovieViewHolder>(LIST_ITEM_IN_TEST,click()))
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))

        onView(withId(R.id.movie_star_actors)).perform(click())
        val actors = MOVIE_IN_TEST.star_actors
        val verifyDirector = StarActorsFragment.stringBuilderForStarActors(actors!!)
        onView(withId(R.id.star_actors_text)).check(matches(withText(verifyDirector)))
    }

}