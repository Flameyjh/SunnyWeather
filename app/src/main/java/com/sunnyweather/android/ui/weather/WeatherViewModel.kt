package com.sunnyweather.android.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Location
import com.sunnyweather.android.logic.model.Weather

class WeatherViewModel : ViewModel() {

    private val locationLivedata = MutableLiveData<Location>()

    //界面相关数据，保证手机旋转时不会消失
    var locationLng = ""
    var locationLat = ""
    var palceName = ""

    //使用Transformations.switchMap来观察searchLivedata对象
    val weatherLiveData = Transformations.switchMap(locationLivedata) { location->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLivedata.value = Location(lng, lat)
    }
}