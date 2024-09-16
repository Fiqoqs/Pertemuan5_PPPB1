package com.example.pertemuan5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity()
{
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.tvUsername.text = intent.getStringExtra("usernameFromLogin")
        binding.tvEmail.text = intent.getStringExtra("emailFromLogin")
        binding.tvPhone.text = intent.getStringExtra("phoneFromLogin")
    }
}