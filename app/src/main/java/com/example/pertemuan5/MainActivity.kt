package com.example.pertemuan5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private val TAG = "MAIN_ACTIVITY"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate dipanggil")

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            btnToSecondActivity.setOnClickListener {
                val intentToSecondActivity =
                    Intent(this@MainActivity, SecondActivity::class.java)
                intentToSecondActivity.putExtra("EXTRA_NAME", editName.text.toString())
                startActivity(intentToSecondActivity)
            }

            btnSendMessage.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Hello!")
                startActivity(Intent.createChooser(intent, "Select an app"))
            }

            btnDial.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:12345678")
                startActivity(intent)
            }

            btnOpenLink.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com")
                startActivity(intent)
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