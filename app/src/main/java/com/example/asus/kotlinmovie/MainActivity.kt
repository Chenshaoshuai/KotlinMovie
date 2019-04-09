package com.example.asus.kotlinmovie

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import com.example.asus.kotlinmovie.view.IView

class MainActivity<T>() : AppCompatActivity(),IView<T> {
    override fun onSuccess(data: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var edit_name = findViewById<EditText>(R.id.edit_name)
        var edit_pass = findViewById<EditText>(R.id.edit_pass)
        var btn_log = findViewById<Button>(R.id.btn_log)





    }

}
