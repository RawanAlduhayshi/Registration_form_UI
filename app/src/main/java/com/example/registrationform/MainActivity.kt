package com.example.registrationform

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val check = validateInputs()
            if (check) {
                printInfo()
            }


        }
    }

    private fun validateInputs(): Boolean {
        if (binding.editTextTextPersonName.toString().isEmpty()) {
            Toast.makeText(this, "Please Enter your name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.editTextTextEmailAddress.toString().isEmpty()) {
            Toast.makeText(this, "Please Enter your E-mail", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.editTextDate.toString().isEmpty()) {
            Toast.makeText(this, "Please Enter your birth date", Toast.LENGTH_SHORT).show()
            return false
        }


        if (binding.ginderOptions.toString().isEmpty()) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.editTextTextPassword.toString().isEmpty()) {
            Toast.makeText(this, "Please select your Password", Toast.LENGTH_SHORT).show()
            return false

        }
        if (binding.editTextTextPassword2.toString().isEmpty()) {
            Toast.makeText(this, "Please repeat your Password", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.editTextTextPassword.toString()
                .equals(binding.editTextTextPassword2.toString())
        ) {
            Toast.makeText(this, "Password is not Maching", Toast.LENGTH_SHORT).show()
            return false

        }
        return true
    }

    @SuppressLint("StringFormatInvalid")
    fun printInfo() {
        binding.result.text=getString(R.string.registration_info,binding.editTextTextPersonName.toString())
    }

//    @SuppressLint("StringFormatInvalid")
//    fun printInfo() {
//        var info = binding.editTextTextPersonName
//        binding.result.text = getString(R.string.registration_info,info)
//    }


}
