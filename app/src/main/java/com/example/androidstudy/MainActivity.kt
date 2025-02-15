package com.example.androidstudy

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Life Cycle Test","Activity started")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life Cycle Test","Activity paused")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life Cycle Test","Activity resumed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Life Cycle Test","Activity restarted")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life Cycle Test","Activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life Cycle Test","Activity is destroyed")
    }


}