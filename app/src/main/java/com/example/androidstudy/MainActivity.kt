package com.example.androidstudy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonForSwing = findViewById<Button>(R.id.btnGoToSecondActivity)

        buttonForSwing.setOnClickListener(){
            val secondActivity = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(secondActivity)

        }


        val numberSet = setOf(1,2,3,4,5,5,3)
        Log.d("numberSet", numberSet.joinToString())

        val mutNumberSet = mutableSetOf(1,2,4,5,9,5,7,3)
        Log.d("mutNumberSet1", mutNumberSet.joinToString())

        mutNumberSet.add(8)
        mutNumberSet.remove(5)
        Log.d("mutNumberSet2", mutNumberSet.joinToString())

        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
        Log.d("numbersMap", numbersMap.entries.joinToString(", "))

        val myList = listOf("Max","Mark","Alex")
        Log.d("numbersMyList", myList.joinToString())

    }


}