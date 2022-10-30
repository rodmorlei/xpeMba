package com.example.desafiomodulo1.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.desafiomodulo1.data.Item
import com.example.desafiomodulo1.databinding.ActivityMainBinding
import com.example.desafiomodulo1.ui.incluiritem.IncluirItemActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val retornoItem = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if(activityResult.resultCode == RESULT_OK) {
            activityResult.data?.let{
                if(it.hasExtra(RETORNO)){
                    //Log.i("teste aaaa", it.getParcelableExtra<Item>(RETORNO).toString())
                }
            }
        }
    }

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
//            val intent = Intent(this, IncluirItemActivity::class.java)
//            startActivity(intent)
            Intent(this, IncluirItemActivity:: class.java).let {
                retornoItem.launch(it)
            }
        }
    }

    companion object {
        const val RETORNO = "retorno_item"
    }

}