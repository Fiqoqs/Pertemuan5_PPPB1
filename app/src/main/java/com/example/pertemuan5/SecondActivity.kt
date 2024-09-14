package com.example.pertemuan5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val TAG = "SECOND_ACTIVITY"
    private lateinit var binding: ActivitySecondBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->

            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data

                val address = data?.getStringExtra("EXTRA_ADDRESS")
                binding.alamatTxt.text = address
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAME")

        with(binding) {
            txtName.text = name

            btnToThirdActivity.setOnClickListener {
                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                launcher.launch(intent)
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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