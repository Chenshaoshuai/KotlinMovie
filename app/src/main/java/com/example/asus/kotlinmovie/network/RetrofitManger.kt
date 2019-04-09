package com.example.asus.kotlinmovie.network

import com.example.asus.kotlinmovie.api.Api
import com.example.asus.kotlinmovie.api.MyApiService
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observer
import rx.android.BuildConfig
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.IOException
import java.util.concurrent.TimeUnit

class RetrofitManger private constructor(){

//    lateinit var  retrofit : Retrofit
//    companion object {
//        val instances : RetrofitManger by lazy ( mode = LazyThreadSafetyMode.SYNCHRONIZED){
//            RetrofitManger()
//        }
//    }
//
//    fun init(string : String){
//       val okHttpClient = OkHttpClient.Builder()
//               .connectTimeout(5,TimeUnit.SECONDS)
//               .readTimeout(5,TimeUnit.SECONDS)
//               .writeTimeout(5,TimeUnit.SECONDS)
//               .build()
//        retrofit = Retrofit.Builder()
//                .baseUrl(string)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build()
//
//        fun <T> createService(tClass: Class<T>): T {
//
//            return retrofit.create(tClass)
//
//        }

    lateinit var myApiService : MyApiService
    lateinit var retrofit : Retrofit

    //单例模式
    companion object {
        val instant : RetrofitManger by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitManger()
        }
    }

    fun init(url : String){
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        myApiService = retrofit.create(myApiService :: class.java)
    }

    fun UPGet(url: String, map: HashMap<String,String>): RetrofitManger {
        myApiService.post(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
        return RetrofitManger.instant
    }



    private val observer = object : Observer<ResponseBody> {

        override fun onCompleted() {

        }


        override fun onError(e: Throwable) {
            if (httpListener != null) {
                httpListener!!.onError(e.message!!)
            }
        }


        override fun onNext(responseBody: ResponseBody) {
            if (httpListener != null) {
                try {
                    httpListener!!.onSuccess(responseBody.string())
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

        }
    }

    interface HttpListener {
        fun onSuccess(jsonStr: String)

        fun onError(error: String)
    }

    private var httpListener: HttpListener? = null

    fun setHttpListener(listener: HttpListener) {
        this.httpListener = listener
    }




    }





