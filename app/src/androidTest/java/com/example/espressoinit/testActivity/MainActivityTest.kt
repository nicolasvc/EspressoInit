package com.example.espressoinit.testActivity

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressoinit.MainActivity
import com.example.espressoinit.R
import org.junit.Test
import org.junit.runner.RunWith
/**
 * En la carpeta AndroidTest es donde se va a ejecutar las pruebas lanzando la aplicación en un dispositivo
 * fisico o virtual
 * */
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    //region Test UI
    /**Usando ALT +Insert podemos agregar un test de lo que deseemos toca poner el decorador de @Test
    /Esto funciona para validar la visibilidad de los componentes dentro de una actividad*/
    @Test
    fun test_isActivityInView() {
        ActivityScenario.launch(MainActivity::class.java)
        //Sirve para validar si la vista que se esta mostrando existe en la actividad
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    /**El nombre los test deben ser claro precisos no hay limite para explicar*/
    @Test
    fun test_visibility_title_nextButton() {
        ActivityScenario.launch(MainActivity::class.java)
        //onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        //onView(withId(R.id.button)).check(matches(isDisplayed()))
        //Para saber si esta oculto o visible en el XML
        //onView(withId(R.id.button)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun test_isTitleTextDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        //Validar que el textview contenga una cadena de texto completa
        //onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
    }
    //endregion

    //region Test de navegación
    /**
     * Para ejecutar acción dentro de un boton a traves de seleccionado el boton y darle perform(click())
     * y validar navigation entre actividades
     * */
    @Test
    fun test_navSecondaryActivity() {
        ActivityScenario.launch(MainActivity::class.java)
        //onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backPress_toMainActivity() {
        ActivityScenario.launch(MainActivity::class.java)
        //onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        //Evento dentro de la aplicacion
        //onView(withId(R.id.button2)).perform(click())
        //EJecuta onBackPressed
        pressBack()
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
    //endregion
}