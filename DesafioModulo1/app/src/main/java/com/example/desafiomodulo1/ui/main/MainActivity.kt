package com.example.desafiomodulo1.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.desafiomodulo1.R
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
        configurarRecyclerView()
    }

    private fun configurarRecyclerView() {
        viewModel.listaItem.observe(this) { lista->
                Log.i("TesteLista", "Lista funcionando")
            atualizarLista(lista)
        }
    }

    private fun atualizarLista(lista: List<Item>) {
        if(lista.isNullOrEmpty()) {
            binding.rvListaItem.visibility = View.GONE
            binding.tvMensagemListaVazia.visibility = View.VISIBLE
            binding.tvQtdItens.text = "0"
        } else {
            binding.rvListaItem.visibility = View.VISIBLE
            binding.tvMensagemListaVazia.visibility = View.GONE
            binding.rvListaItem.adapter = ItemAdapter(listaItem = lista)
            binding.tvQtdItens.text = lista.size.toString()
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
        binding.fabAddNovoItem.setOnLongClickListener{
            viewModel.limparListaItem()
            Toast.makeText(this, R.string.lista_limpa_sucesso,
            LENGTH_LONG
            ).show()
            it.isLongClickable
        }
    }

    companion object {
        const val RETORNO = "retorno_item"
    }

}