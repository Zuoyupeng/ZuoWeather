package com.android.zuo.weather.utils

import android.widget.Toast
import com.android.zuo.weather.WeatherApplication

fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(WeatherApplication.context, this, duration).show()
}