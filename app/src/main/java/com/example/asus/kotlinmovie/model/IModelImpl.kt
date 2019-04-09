package com.example.asus.kotlinmovie.model

import com.example.asus.kotlinmovie.callback.MyCallBack

interface IModelImpl {
    fun getNetData(url:String, map: HashMap<String,String>, myCallBack: MyCallBack<Object>)
}