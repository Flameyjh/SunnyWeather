package com.yjhsunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yjhsunnyweather.android.logic.Repository
import com.yjhsunnyweather.android.logic.model.Place

//逻辑层和UI层之间的桥梁

class PlaceViewModel : ViewModel(){
    //数据持久化
    fun savePlace(place: Place) = Repository.savePlace(place)
    fun getSavedPlace() = Repository.getSavedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()

    private val searchLivedata = MutableLiveData<String>()

    val placeList = ArrayList<Place>() //用于对界面上的城市数据进行缓存，保证手机旋转时不会丢失

    //使用Transformations.switchMap来观察searchLivedata对象
    val placeLiveData = Transformations.switchMap(searchLivedata){query->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String){
        searchLivedata.value = query
    }
}