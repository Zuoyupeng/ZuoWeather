package com.android.zuo.weather

import android.app.Application
import android.content.Context

class WeatherApplication : Application() {

    companion object {
        const val TOKEN = ""
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}