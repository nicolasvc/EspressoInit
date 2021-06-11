package com.example.espressoinit

import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

/**
 * Author: http://www.qaautomated.com/2016/01/how-to-test-toast-message-using-espresso.html
 */
class ToastMatcher : TypeSafeMatcher<Root?>() {


    //Las pantallas pueden tener su propio token
    override fun describeTo(description: Description?) {
        description?.appendText("is toast")
    }

    //Aca se obtiene el token de la vetanana de la activitidad y tambien de la venta de la aplicacion
    override fun matchesSafely(item: Root?): Boolean {
        val type: Int? = item?.windowLayoutParams?.get()?.type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken: IBinder = item.getDecorView().getWindowToken()
            val appToken: IBinder = item.getDecorView().getApplicationWindowToken()
            if (windowToken === appToken) { // means this window isn't contained by any other windows.
                return true
            }
        }
        return false
    }

}