package com.example.asus.kotlinmovie.api

import retrofit2.http.QueryMap
import retrofit2.http.Url
import okhttp3.ResponseBody
import retrofit2.http.POST
import rx.Observable


interface MyApiService {
     @POST
     fun post(@Url url: String, @QueryMap map: Map<String, String>): Observable<ResponseBody>

 }