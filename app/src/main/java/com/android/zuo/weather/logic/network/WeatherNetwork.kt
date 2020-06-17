package com.android.zuo.weather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 网络资源访问入口
 */
object WeatherNetwork {

    private val placeService = ServiceCreator.create<PlaceService>()

    /**
     * 发起获取城市数据请求
     */
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    /**
     * 实现一个Call拓展方法，使用协程挂起函数，将返回值返回
     */
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body) else continuation.resumeWithException(
                        RuntimeException("res body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}