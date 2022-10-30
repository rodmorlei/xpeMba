package com.example.desafiomodulo1.data.repository

import com.example.desafiomodulo1.data.Item

class MemoryRepository(novaLista: MutableList<Item>) {

    private val listDb: MutableList<Item> = novaLista

    fun incluir(item: Item) {
        listDb.add(item)
    }

    fun limparLista() {
        listDb.clear()
    }

    fun retornarLista() = listDb.toList()

}