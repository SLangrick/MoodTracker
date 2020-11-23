package com.example.moodtracker

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.View
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import com.anychart.core.Chart
import java.io.InputStream
import java.net.URL

class Fetch(val callback: (Chart) -> Unit): AsyncTask<Void, Void, Chart>() {
    override fun onPostExecute(result: Chart?) {
        if(result != null){
            callback(result)
        }
    }

    override fun doInBackground(vararg p0: Void?): Chart? {

        val pie = AnyChart.pie()
        pie.data(TotalPieFragment.data)
        println(TotalPieFragment.data)



        return pie
    }
}