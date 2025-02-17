package com.example.androidstudy

import android.util.Log
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment Life Cycle Test","Fragment 2 detached")
    }
}