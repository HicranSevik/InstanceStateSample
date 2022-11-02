package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    var name: String = "loser"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            //
            if (binding.tvGreeting.text.toString().contains(name)) {
                name = binding.tvName.text.toString()
            }
            putString("username", name)
        }
        Log.i(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        name = savedInstanceState.getString("username", name)
        binding.tvGreeting.text = "Hello " + name
        Log.i(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")

    }

    override fun onResume() {
        super.onResume()
        binding.btnGreet.setOnClickListener {
            if (binding.tvName.text.toString().isNotEmpty()) {
                name = binding.tvName.text.toString()
            }
            binding.tvGreeting.text = "Hello " + name
        }
        binding.tvGreeting.text = "Hello " + name
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
}