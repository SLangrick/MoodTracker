package com.example.moodtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast

class ButtonFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_button, container, false)
        var mainActivity: MainActivity = activity as MainActivity
        val smile0: ImageButton = view.findViewById<View>(R.id.smileZero) as ImageButton
        smile0.setOnClickListener {
            TotalPieFragment.rawData[0] = TotalPieFragment.rawData[0] + 1
            mainActivity.btn()
        }

        val smile1: ImageButton = view.findViewById<View>(R.id.smileOne) as ImageButton
        smile1.setOnClickListener {
            TotalPieFragment.rawData[1] = TotalPieFragment.rawData[1] + 1
            mainActivity.btn()
        }

        val smile2: ImageButton = view.findViewById<View>(R.id.smileTwo) as ImageButton
        smile2.setOnClickListener {
            TotalPieFragment.rawData[2] = TotalPieFragment.rawData[2] + 1
            mainActivity.btn()
        }

        val smile3: ImageButton = view.findViewById<View>(R.id.smileThree) as ImageButton
        smile3.setOnClickListener {
            TotalPieFragment.rawData[3] = TotalPieFragment.rawData[3] + 1
            mainActivity.btn()
        }

        val smile4: ImageButton = view.findViewById<View>(R.id.smileFour) as ImageButton
        smile4.setOnClickListener {
            TotalPieFragment.rawData[4] = TotalPieFragment.rawData[4] + 1
            mainActivity.btn()
        }
        return view
    }
}