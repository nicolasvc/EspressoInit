package com.example.espressoinit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_launch_dialog.setOnClickListener {
            showDialog()
        }

    }

    private fun showDialog(){
        MaterialDialog(this)
            .show {
                input (
                    waitForPositiveButton = true,
                    allowEmpty = false
                ){ _, name ->
                    setNameToTextView(name.toString())
                    showToast(name.toString())
                }
                title(R.string.text_enter_name)
                positiveButton(R.string.text_ok)
            }
    }

    private fun showToast(message:String){
        Toast.makeText(this, buildToastMessage(message),Toast.LENGTH_SHORT).show()
    }

    private fun setNameToTextView(name: String){
        text_name.text = name
    }

    companion object{
        fun buildToastMessage(name:String) = "Your name is $name"
    }

}








