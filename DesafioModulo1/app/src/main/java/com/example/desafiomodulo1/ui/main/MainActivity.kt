package com.example.desafiomodulo1.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiomodulo1.databinding.ActivityMainBinding
import com.example.desafiomodulo1.ui.incluiritem.IncluirItemActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        configurarListeners()

    }

    private fun configurarListeners() {
        configurarFabListener()
    }

    private fun configurarFabListener() {
        binding.fabAddNovoItem.setOnClickListener {
            val intent = Intent(this, IncluirItemActivity::class.java)
            startActivity(intent)
        }
    }
}