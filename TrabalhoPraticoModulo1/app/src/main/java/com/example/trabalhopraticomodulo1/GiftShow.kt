package com.example.trabalhopraticomodulo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GiftShow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gift_show)
        Log.i("Log 2", "Tela de presente apresentada")
    }
}