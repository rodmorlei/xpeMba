package com.example.trabalhopraticomodulo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalhopraticomodulo2.databinding.ActivityTextViewBinding

class ActivityTextView : AppCompatActivity() {

    private lateinit var binding: ActivityTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val bundle = intent.extras

        if (bundle != null){
            val message = bundle.getString("name")
            binding.textViewId.text = message
        }

    }
}