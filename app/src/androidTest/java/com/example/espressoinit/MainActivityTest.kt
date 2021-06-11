package com.example.espressoinit

import android.app.Activity
import android.app.Instrumentation
import android.app.Instrumentation.*
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.exp


@RunWith(AndroidJUnit4::class)
class MainActivityTest{


    @Test
    fun text_showDialog_captureNameInput() {
        //Given and open activity
        val activity = ActivityScenario.launch(MainActivity::class.java)
        val EXPECTED_NAME = "Morfeo"

        //Execute Open dialog and validate if the name of title correspond to Id String
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        //Validate when click ok button no close dialog
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        //Enter INPUT
        onView(withId(R.id.md_input_message)).perform(typeText(EXPECTED_NAME))
        onView(withText(R.string.text_ok)).perform(click())

        //Validate dialog is gone we have to use doesNotExist because when use matches is like the view is displayed but in this case is not
        onView(withText(R.string.text_enter_name)).check(doesNotExist())

        onView(withId(R.id.text_name)).check(matches(withText(EXPECTED_NAME)))


    }
}