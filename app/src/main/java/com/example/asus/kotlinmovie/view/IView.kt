package com.example.asus.kotlinmovie.view

interface IView<T> {
    fun onSuccess(data: T)
}