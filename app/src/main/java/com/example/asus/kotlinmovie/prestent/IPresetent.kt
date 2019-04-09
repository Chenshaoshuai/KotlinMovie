package com.example.asus.kotlinmovie.prestent

interface IPresetent {
    fun RequestData(url: String, params: Map<String, String>, clazz: Class<*>)
    fun getRequest(Url: String, clazz: Class<*>)
    fun putRequest(url: String, params: Map<String, String>, clazz: Class<*>)
}