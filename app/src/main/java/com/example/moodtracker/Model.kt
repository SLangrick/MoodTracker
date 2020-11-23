package com.example.moodtracker

import java.text.SimpleDateFormat
import java.util.*

class Model(var TodayDate: Date, var Feel: Int) {
    fun getDay(): String{
        return SimpleDateFormat("EE").format(TodayDate)
    }
}