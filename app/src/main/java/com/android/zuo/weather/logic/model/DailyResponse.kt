package com.android.zuo.weather.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * 未来几天天气数据模型
 */
data class DailyResponse(val status: String, val result: Result) {

    data class Result(val daily: Daily)

    data class Daily(
        val skycon: List<Skycon>, val temperature: List<Temperature>
        , @SerializedName("life_index") val lifeIndex: LifeIndex
    )

    data class Temperature(val max: Float, val min: Float)

    data class Skycon(val value: String, val date: Date)

    data class LifeIndex(
        val coldRisk: List<LifeDesc>, val carWashing: List<LifeDesc>,
        val ultraviolet: List<LifeDesc>, val dressing: List<LifeDesc>
    )

    data class LifeDesc(val desc: String)
}