package com.example.moodtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import java.util.*
import java.util.ArrayList;


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





//        var test = Model(Calendar.getInstance().time, 2)
//        println(Calendar.getInstance().time)
//        println(test.getDay())
    }

    fun btn(){
        TotalPieFragment.data.clear()
        TotalPieFragment.data.add(ValueDataEntry("V Sad", TotalPieFragment.rawData[0]))
        TotalPieFragment.data.add(ValueDataEntry("Sad", TotalPieFragment.rawData[1]))
        TotalPieFragment.data.add(ValueDataEntry("Neutral", TotalPieFragment.rawData[2]))
        TotalPieFragment.data.add(ValueDataEntry("Happy", TotalPieFragment.rawData[3]))
        TotalPieFragment.data.add(ValueDataEntry("V Happy", TotalPieFragment.rawData[4]))
        totalPieReload()
    }

    fun totalPieReload(){
        //Find View
        val view: View = findViewById<View>(R.id.TotalPieFragment)
        //Find oldchart and layout, Then delete chart
        val oldChart = view.findViewWithTag<AnyChartView>("Chart") as AnyChartView
        val LLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        LLayout.removeView(oldChart)

        //Create Chart Val
        val chart: AnyChartView = AnyChartView(this)
        chart.tag = "Chart"
        //Set data to var and chart
        val pie = AnyChart.pie()
        pie.data(TotalPieFragment.data)

        //Add chart to layout
        LLayout.addView(chart)
        //Find chart on layout
        val anyChartView = view.findViewWithTag<AnyChartView>("Chart") as AnyChartView
        //Change Variables of chart
        chart.layoutParams.height = 700
        chart.layoutParams.width = LinearLayoutCompat.LayoutParams.MATCH_PARENT
        //Add chart to view
        anyChartView.setChart(pie)
    }
}