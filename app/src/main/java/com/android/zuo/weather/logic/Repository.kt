package com.android.zuo.weather.logic

import androidx.lifecycle.liveData
import com.android.zuo.weather.logic.model.Place
import com.android.zuo.weather.logic.network.WeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 * 仓库层统一入口
 */
object Repository {

    /**
     * 搜索城市数据
     */
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = WeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("res status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result as Result<List<Place>>)
    }

}