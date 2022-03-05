package com.yjhsunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

//这里把所有数据模型类都定义在了RealtimeResponse内部，防止和其他接口的数据模型类同名冲突

data class RealtimeResponse(val status: String, val result: Result) {

    data class Result(val realtime: Realtime)

    data class Realtime(
        val temperature: Float, val skycon: String,
        @SerializedName("air_quality") val airQuality: AirQuality
    )

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)
}
