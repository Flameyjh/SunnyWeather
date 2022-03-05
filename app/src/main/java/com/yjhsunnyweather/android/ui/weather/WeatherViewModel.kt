package com.yjhsunnyweather.android.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yjhsunnyweather.android.logic.Repository
import com.yjhsunnyweather.android.logic.model.Location

class WeatherViewModel : ViewModel() {

    private val locationLivedata = MutableLiveData<Location>()

    //界面相关数据，保证手机旋转时不会消失
    var locationLng = ""
    var locationLat = ""
    var placeName = ""

    //使用Transformations.switchMap来观察searchLivedata对象
    val weatherLiveData = Transformations.switchMap(locationLivedata) { location->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLivedata.value = Location(lng, lat)
    }
}