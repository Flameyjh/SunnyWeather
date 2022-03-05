package com.yjhsunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.yjhsunnyweather.android.SunnyWeatherApplication
import com.yjhsunnyweather.android.logic.model.Place

//数据持久化

object PlaceDao {
    fun savePlace(place: Place) {
        sharePreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavePlace(): Place {
        val place = sharePreferences().getString("place", "")
        return Gson().fromJson(place, Place::class.java)
    }

    fun isPlaceSaved() = sharePreferences().contains("place")

    private fun sharePreferences() =
        SunnyWeatherApplication.context.getSharedPreferences("yjh_weather", Context.MODE_PRIVATE)
}

