package com.example.espressoinit

import android.app.Activity
import android.app.Instrumentation
import android.app.Instrumentation.*
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.exp


@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    //Esto ejecuta un intent dentor de la clase MainActivity
    @get:Rule
    val intentTestRUle = IntentsTestRule(MainActivity::class.java)

    @Test
    fun test_validate_intentsendtopickpackage() {

        //Lanzar data dentro del intent
        //Given
        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )
        val activityResult = createGalleryPickActivityResultStub()
        //Intending sirve para hacer test a un intent y respondWith es el encargado de pasarle el activityResult
        intending(expectedIntent).respondWith(activityResult)

        onView(withId(R.id.button_open_gallery)).perform(click())
        //EJecuta el intent
        intended(expectedIntent)
    }

    //Funcion encargada de simular el intent y el activityResult de obtener una imagen de la galeria
    private fun createGalleryPickActivityResultStub(): ActivityResult {
        val resources : Resources = InstrumentationRegistry.getInstrumentation().context.resources
        val imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(R.drawable.ic_launcher_background))

        val resulttIntent = Intent()
        resulttIntent.setData(imageUri)
        return  ActivityResult(Activity.RESULT_OK, resulttIntent)

    }
}