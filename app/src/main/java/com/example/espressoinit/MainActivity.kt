package com.example.espressoinit

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


const val KEY_IMAGE_DATA = "data"


class MainActivity : AppCompatActivity() {

    private val TAG: String = "AppDebug"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_launch_camera.setOnClickListener {
            dispatchCameraIntent()
        }
    }

    private fun dispatchCameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        obtenerResultadoActividad.launch(intent)
    }

    private var obtenerResultadoActividad =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Log.d(TAG, "REQUEST_IMAGE_CAPTURE detected.")
                result.data?.extras.let { extras ->
                    if (extras == null || !extras.containsKey(KEY_IMAGE_DATA)) {
                        showMessage()
                    }
                    val imageBitmap = extras?.get(KEY_IMAGE_DATA) as Bitmap?
                    image.setImageBitmap(imageBitmap)
                }
            } else {
                showMessage()
            }
        }

    private fun showMessage() {
        Toast.makeText(this, "No se capturo ninguna imagen", Toast.LENGTH_SHORT).show()
    }


}







