package com.example.asus.kotlinmovie.callback

import com.example.asus.kotlinmovie.entity.UserBean

interface MyCallBack<T>{
        fun getSuccess(data: UserBean)
        fun getError(error : T)
    }
