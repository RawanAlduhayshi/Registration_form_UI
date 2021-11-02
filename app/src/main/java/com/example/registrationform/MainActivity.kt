package com.example.registrationform

import android.annotation.SuppressLint
import android.os.Bundle
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


        if (binding.editTextTextPersonName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter your name", Toast.LENGTH_SHORT).show()
            return false
        } else {
            if (binding.editTextTextEmailAddress.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please Enter your E-mail", Toast.LENGTH_SHORT).show()
                return false
            } else {
                if (binding.editTextDate.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please Enter your birth date", Toast.LENGTH_SHORT).show()
                    return false
                } else {
                    if (binding.ginderOptions.toString().isEmpty()) {
                        Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
                        return false
                    } else {
                        if (binding.editTextTextPassword.getText().toString().isEmpty()) {
                            Toast.makeText(this, "Please select your Password", Toast.LENGTH_SHORT)
                                .show()
                            return false

                        } else {
                            if (binding.editTextTextPassword2.getText().toString().isEmpty()) {
                                Toast.makeText(
                                    this,
                                    "Please repeat your Password",
                                    Toast.LENGTH_SHORT
                                ).show()
                                return false
                            } else {
                                return if (binding.editTextTextPassword.getText()
                                        .toString() != binding.editTextTextPassword2.getText()
                                        .toString()
                                ) {
                                    Toast.makeText(
                                        this,
                                        "Password is not Maching",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    false

                                } else {
                                    true
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @SuppressLint("StringFormatInvalid")
    fun printInfo() {
        binding.result.text = "${binding.editTextTextPersonName.text}"
        binding.result2.text = "${binding.editTextTextEmailAddress.text}"
        binding.result3.text = "${binding.editTextTextPassword.text}"
        binding.result4.text = when (binding.ginderOptions.checkedRadioButtonId) {
            R.id.option_female -> "female"
            else -> "male"
        }
    }
}





