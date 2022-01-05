package com.sparrow.registration_ui

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class RegisterActivity : AppCompatActivity()  {

    private var myYear = 0
    private var myMonth = 0
    private var myDay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register_step_two)

        val btnNext = findViewById<Button>(R.id.btnNext)
//
        btnNext.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
        }

        //Connect the Edit Text variable that you created with the one specified in the layout for receiving the data value

        var birthDay = findViewById<EditText>(R.id.dateOfBirth)

        //Connect the EditText variable with an onClickListener
        birthDay.setOnClickListener{
            //Declare a date picker dialog to pick the date
            val datePicker = DatePickerDialog(this,
                { _, year, month, dayOfMonth -> //set the date on the editText variable
                    birthDay.setText(dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                }, myYear, myMonth, myDay
            )

            //show the date picker dialog
            datePicker.show()
        }
    }


    fun showToast(view: View?) {
        val check = Toast.makeText(this, "Please Accept Terms and Conditions", Toast.LENGTH_SHORT)
        check.show()
    }

    fun createAccount(view: View?) {
        //Compare passwords
        //Throw error exceptions
        //Get the data from the edit texts
        //Add an Intent
        //Throw Toast
        val submitToast = Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT)
        submitToast.show()
    }

    fun onClick(v: View) {
        var birthDay = findViewById<EditText>(R.id.dateOfBirth)
        if (v === birthDay) {

            //Declare a calendar to get current selected date
            val c = Calendar.getInstance()
            myYear = c[Calendar.YEAR]
            myMonth = c[Calendar.MONTH]
            myDay = c[Calendar.DAY_OF_MONTH]
        }
    }
}