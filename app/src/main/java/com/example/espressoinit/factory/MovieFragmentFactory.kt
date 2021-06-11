package com.example.espressoinit.factory


import androidx.fragment.app.FragmentFactory
import com.example.espressoinit.DirectorsFragment
import com.example.espressoinit.MovieDetailFragment
import com.example.espressoinit.StarActorsFragment



/**
 * //TODO investigar mas sobre este tema
 * La clase FragmentFactory nos permite obtener una fabrica de fragmentos
 * */
class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =
        when(className){
            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}













