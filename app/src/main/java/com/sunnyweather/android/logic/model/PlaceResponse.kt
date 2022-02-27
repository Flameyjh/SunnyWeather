package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

//定义数据模型：按照接口返回的JSON格式定义这里的数据类

data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    val name: String, val location: Location,
    @SerializedName("formatted_address")
    val address: String
)

data class Location(val lng: String, val lat: String)
