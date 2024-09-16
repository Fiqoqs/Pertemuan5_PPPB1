package com.example.pertemuan5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val phone = binding.etPhone.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && binding.cbTerms.isChecked) {
                val intentToSecondActivity = Intent(this, SecondActivity::class.java)
                intentToSecondActivity.putExtra("username", username)
                intentToSecondActivity.putExtra("email", email)
                intentToSecondActivity.putExtra("phone", phone)
                intentToSecondActivity.putExtra("password", password)
                startActivity(intentToSecondActivity)
            }else {
                Toast.makeText(this, "Please fill form above", Toast.LENGTH_SHORT).show()
            }
        }

    }

}