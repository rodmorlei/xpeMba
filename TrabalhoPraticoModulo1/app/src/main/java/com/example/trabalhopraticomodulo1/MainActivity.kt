package com.example.trabalhopraticomodulo1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Log 1", "Aplicação criada")

        val button: Button = findViewById(R.id.btnOpenPresent)
        button.setOnClickListener {
            val intent = Intent(this, GiftShow::class.java)
            startActivity(intent)
        }

    }
}