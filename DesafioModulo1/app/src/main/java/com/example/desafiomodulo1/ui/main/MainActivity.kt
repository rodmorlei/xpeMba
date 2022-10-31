package com.example.desafiomodulo1.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.desafiomodulo1.data.Item
import com.example.desafiomodulo1.databinding.ActivityMainBinding
import com.example.desafiomodulo1.ui.incluiritem.IncluirItemActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val retornoItem = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == RESULT_OK) {
            activityResult.data?.let {
                if (it.hasExtra(RETORNO)) {
                    viewModel.salvarItem(it.getParcelableExtra(RETORNO)!!)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        iniciarDados()
        configurarListeners()
        configurarObservers()
    }

    private fun configurarObservers() {
        configurarAtualizacaoLista()
    }

    private fun configurarAtualizacaoLista() {
        viewModel.listaItem.observe(this) { lista->
                Log.i("TesteLista", "Lista funcionando")
        }
    }

    private fun iniciarDados() {
        viewModel.iniciarDados()
    }

    private fun configurarListeners() {
        configurarFabListener()
    }

    private fun configurarFabListener() {
        binding.fabAddNovoItem.setOnClickListener {
            Intent(this, IncluirItemActivity::class.java).let {
                retornoItem.launch(it)
            }
        }
    }

    companion object {
        const val RETORNO = "retorno_item"
    }

}