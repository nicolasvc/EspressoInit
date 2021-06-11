package com.example.espressoinit

import android.app.Activity
import android.app.Instrumentation
import android.app.Instrumentation.*
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.espressoinit.ImageViewHasDrawableMatcher.hasDrawable
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.exp


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    /*
    *Esto ejecuta un intent dentro de la clase MainActivity
    * De igual forma la decorador Rule es lo que primero se va a ejecutar cuando se ejecute cualquier test
    * */

    @get:Rule
    val intentTestRUle = IntentsTestRule(MainActivity::class.java)


    @Test
    fun test_cameraIntent_isBitmapSetToImageView() {
        //GIVEN
        val activityResuld = createImageCaptureActivityResultSub()
        val expectedIntent : Matcher<Intent> = hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        intending(expectedIntent).respondWith(activityResuld)

        //Execute
        //Validamos que el ImageView no Contenga ningun Drawable
        onView(withId(R.id.image)).check(matches(not(hasDrawable())))
        onView(withId(R.id.button_launch_camera)).perform(click())
        intending(expectedIntent)
        //Validamos que si exista ya un drawable en el imageView
        onView(withId(R.id.image)).check(matches(hasDrawable()))
    }

    private fun createImageCaptureActivityResultSub(): ActivityResult {
        val bundle = Bundle()
        bundle.putParcelable(
            KEY_IMAGE_DATA,
            BitmapFactory.decodeResource(
                intentTestRUle.activity.resources,
                R.drawable.ic_launcher_background
            )
        )
        val resultData = Intent()
        resultData.putExtras(bundle)
        return ActivityResult(Activity.RESULT_OK, resultData)
    }
}