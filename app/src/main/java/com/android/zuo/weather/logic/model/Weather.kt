package com.android.zuo.weather.logic.model

/**
 * 天气数据模型
 */
data class Weather(val realtime: RealtimeResponse.Realtime,val daily: DailyResponse.Daily)