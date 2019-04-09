package com.example.asus.kotlinmovie.prestent

import com.example.asus.kotlinmovie.model.IModel
import com.example.asus.kotlinmovie.view.IView





class IPresentImpl :IPresetent {
    private val iView: IView<*>? = null
    private val iModel: IModel? = null





    override fun RequestData(url: String, params: Map<String, String>, clazz: Class<*>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRequest(Url: String, clazz: Class<*>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun putRequest(url: String, params: Map<String, String>, clazz: Class<*>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

