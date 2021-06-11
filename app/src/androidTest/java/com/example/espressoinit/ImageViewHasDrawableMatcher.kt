package com.example.espressoinit

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

object ImageViewHasDrawableMatcher {

    /*BoundedMatcher se pasa la vista y el componente que se quiere validar que exista
    * dentro de la vista
    * */
    fun hasDrawable():BoundedMatcher<View,ImageView>{

        return object : BoundedMatcher<View,ImageView> (ImageView::class.java){
            //Muestra una descripcion breve de lo que esperamos no tiene fin
            override fun describeTo(description: Description?) {
                description?.appendText("has drawable")
            }
            /*Aca es donde se valida si el componente tiene cierta propíedad atributo
            * Como por ejemplo en este caso que el ImageView contenga un drawable
            * */
            override fun matchesSafely(item: ImageView?): Boolean {
              return item?.drawable != null
            }
        }
    }
}