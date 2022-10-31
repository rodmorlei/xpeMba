package com.example.desafiomodulo1.ui.main

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiomodulo1.data.Item
import com.example.desafiomodulo1.databinding.ListItemItemBinding


class ItemAdapter(private val listaItem: List<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private lateinit var  binding: ListItemItemBinding

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        fun bind(item: Item) {
            binding.apply {
                tvDescricao.text = item.descricao
                tvQuantidade.text = item.quantidade
                cbSelect.isChecked = item.coletado
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListItemItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item= listaItem[position])
    }

    override fun getItemCount(): Int = listaItem.size

}