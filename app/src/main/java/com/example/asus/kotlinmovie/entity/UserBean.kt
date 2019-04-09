package com.example.asus.kotlinmovie.entity

data class UserBean(
        val result: Result,
        val message: String,
        val status: String
) {
    data class Result(
            val headPic: String,
            val nickName: String,
            val phone: String,
            val sessionId: String,
            val sex: Int,
            val userId: Int
    )
}