package com.example.pertemuan5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val TAG = "SECOND_ACTIVITY"
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.login.setOnClickListener {
            if (binding.etUsername.text.toString() == intent.getStringExtra("username") && binding.etPassword.text.toString() == intent.getStringExtra("password")) {
                val intentToThirdActivity = Intent(this, ThirdActivity::class.java)
                intentToThirdActivity.putExtra("usernameFromLogin", intent.getStringExtra("username"))
                intentToThirdActivity.putExtra("emailFromLogin", intent.getStringExtra("email"))
                intentToThirdActivity.putExtra("phoneFromLogin", intent.getStringExtra("phone"))
                intentToThirdActivity.putExtra("passwordFromLogin", intent.getStringExtra("password"))
                startActivity(intentToThirdActivity)
            }else {
                Toast.makeText(this, "Usename or password is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy dipanggil")
    }

}