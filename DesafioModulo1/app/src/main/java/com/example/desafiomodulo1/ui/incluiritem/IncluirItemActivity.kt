package com.example.desafiomodulo1.ui.incluiritem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiomodulo1.R
import com.example.desafiomodulo1.databinding.ActivityIncluirItemBinding

class IncluirItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIncluirItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncluirItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarListeners()
    }

    private fun configurarListeners() {
        configurarListenerBtnCancelar()
        configurarListenerBtnIncluir()
    }

    private fun configurarListenerBtnIncluir() {
        binding.btnIncluir.setOnClickListener {
            incluirItem()
        }
    }

    private fun incluirItem() {
        val descricao = binding.descricaoItemET.text.toString()
        val quantidade = binding.quantidadeItemET.text.toString()

        if (descricao.trim().isEmpty()) {
            binding.descricaoItemTIL.error = getString(R.string.err_sem_descricao)
        } else {
            binding.descricaoItemTIL.error = null;
        }

        if (quantidade.trim().isEmpty()) {
            binding.quantidadeItemTIL.error = getString(R.string.err_sem_quantidade)
        } else {
            binding.quantidadeItemTIL.error = null
        }

        if (descricao.trim().isNotEmpty() && quantidade.trim().isNotEmpty()){
            Toast.makeText(applicationContext, "Item $descricao incluído com sucesso", Toast.LENGTH_LONG).show()
            finish()
        }

    }

    private fun configurarListenerBtnCancelar() {
        binding.btnCancelar.setOnClickListener { finish() }
    }
}