package com.example.desafiomodulo1.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiomodulo1.data.Item
import com.example.desafiomodulo1.data.repository.MemoryRepository

class MainViewModel: ViewModel() {
    private var memoryRepository: MemoryRepository = MemoryRepository(mutableListOf())
    private val _listadeItens = MutableLiveData<List<Item>>()

    val listaItem: LiveData<List<Item>> = _listadeItens

    fun iniciarDados(){
        _listadeItens.value = memoryRepository.retornarLista()
    }

    fun salvarItem(item: Item) {
        Log.i("ItemNOVO", "Item recebido: $item")

        memoryRepository.incluir(item)
        atualizarListaItem()

    }

    fun limparListaItem() {
        memoryRepository.limparLista()
        atualizarListaItem()
    }

    private fun atualizarListaItem() {
        _listadeItens.value = memoryRepository.retornarLista()
    }

}