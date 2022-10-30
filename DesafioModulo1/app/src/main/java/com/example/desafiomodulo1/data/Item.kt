package com.example.desafiomodulo1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(var descricao: String, var quantidade: String, var coletado: Boolean): Parcelable
