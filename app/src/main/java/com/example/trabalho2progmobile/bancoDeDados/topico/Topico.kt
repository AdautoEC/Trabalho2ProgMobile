package com.example.trabalho2progmobile.bancoDeDados.topico

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "topicos")
data class Topico(
    @PrimaryKey(autoGenerate = true)
    val topicoId: Int = 0,
    val nome: String,
    val descricao: String,

)