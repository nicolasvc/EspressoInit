package com.example.espressoinit.testActivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressoinit.R
import com.example.espressoinit.SecondaryActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest {

    //Test rule o regla de prueba
    @get: Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun test_isactivityinView(){
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_backbotton() {
        onView(withId(R.id.secondary_title)).check(matches(isDisplayed()))

        onView(withId(R.id.button2)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleTextDIsplayed() {
        onView(withId(R.id.secondary_title)).check(matches(withText(R.string.text_secondaryactivity)))
    }
}