package com.example.trabalhopraticomodulo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalhopraticomodulo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnOpenPresent.setOnClickListener {
            val intent = Intent(this, ActivityTextView::class.java)
            intent.putExtra("name", binding.descricaoItemET.text.toString())
            startActivity(intent)
        }

    }
}