package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

//为了项目能在任何位置通过SunnyWeatherApplication.context来获取context对象

class SunnyWeatherApplication : Application() {
    companion object{
        @SuppressLint("StaticFieldLeak") //让AndroidStudio忽略警告
        lateinit var context: Context

        const val TOKEN = "yOs0jMlHbopfFqPA" //彩云平台令牌
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}