package com.example.dialogs

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
//            showAlertDialog()
            showCustomDialog()
        }
    }

    fun showAlertDialog(){
        AlertDialog.Builder(this)
            .setTitle("Alert")
            .setMessage("Are you sure you  want to log out ")
            .setPositiveButton("Yes"){_,_ ->
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->

                dialog.dismiss()
            }
            .setCancelable(true)
            .show()

    }

    fun showCustomDialog(){

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
        val btnOk = dialog.findViewById<Button>(R.id.btnOk)
        val message = dialog.findViewById<TextView>(R.id.tvMessage)
        message?.text = "Do you want to logout "
        btnCancel?.setOnClickListener {
            dialog.dismiss()
        }
        btnOk?.setOnClickListener {
            finish()
        }
        dialog.show()

    }
}