package com.example.trabalho2progmobile.utils.dataHora

import java.text.SimpleDateFormat
import java.util.*

class DataHora {
    companion object {
        fun gerarDataHora(): String {
            val current = Calendar.getInstance()
            val formatter = SimpleDateFormat("ddMMyyyy HHmmss")
            return formatter.format(current.time)
        }
    }
}