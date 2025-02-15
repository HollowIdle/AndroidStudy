package com.example.androidstudy

import android.util.Log
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(TODO()) {

    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment Life Cycle Test","Fragment 2 detached")
    }
}