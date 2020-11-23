package com.example.moodtracker

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import com.anychart.core.Chart
import java.util.ArrayList


class TotalPieFragment : Fragment() {
    companion object{
        val data: MutableList<DataEntry> = ArrayList()
        val rawData: ArrayList<Int> = ArrayList()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Find View
        val view:View = inflater.inflate(R.layout.fragment_total_pie, container, false)
        //Create Chart Val
        val chart: AnyChartView = AnyChartView(context)
        chart.tag = "Chart"


        //Set data to var and chart
        val pie = AnyChart.pie()
        rawData.add(0, 0)
        rawData.add(1,0)
        rawData.add(2,0)
        rawData.add(3,0)
        rawData.add(4,0)



        data.add(ValueDataEntry("V Sad", rawData[0]))
        data.add(ValueDataEntry("Sad", rawData[1]))
        data.add(ValueDataEntry("Neutral", rawData[2]))
        data.add(ValueDataEntry("Happy", rawData[3]))
        data.add(ValueDataEntry("V Happy", rawData[4]))
        pie.data(data)

        //Find layout and Add chart to layout
        val LLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        LLayout.addView(chart)
        //Find Chart on layout
        val anyChartView = view.findViewWithTag<AnyChartView>("Chart") as AnyChartView
        //Change Variables of chart
        chart.layoutParams.height = 700
        chart.layoutParams.width = LinearLayoutCompat.LayoutParams.MATCH_PARENT

        //Add chart to view
        anyChartView.setChart(pie)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}