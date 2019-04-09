package com.example.asus.kotlinmovie.model



import com.example.asus.kotlinmovie.callback.MyCallBack
import com.example.asus.kotlinmovie.entity.UserBean
import com.example.asus.kotlinmovie.network.RetrofitManger
import com.google.gson.Gson

class IModel : IModelImpl {

    override fun getNetData(url: String, map: HashMap<String, String>, myCallBack: MyCallBack<Object>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        RetrofitManger.instant.UPGet(url,map).setHttpListener(object : RetrofitManger.HttpListener{
            override fun onSuccess(jsonStr: String) {
                val bean = Gson().fromJson<UserBean>(jsonStr)
                myCallBack.getSuccess(bean)
            }

            override fun onError(error: String) {

            }

        })
    }


}

private fun <T> MyCallBack<T>.getSuccess(data: UserBean?) {


}

inline fun <reified T> Gson.fromJson(json: String) = fromJson(json, T::class.java)
