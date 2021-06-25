package com.example.trabalho2progmobile.bancoDeDados

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.bancoDeDados.topico.TopicoDao
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.bancoDeDados.usuario.UsuarioDao
import com.example.trabalho2progmobile.utils.converters.Converters

@Database(entities = [Usuario::class, Topico::class], version = 1)
@TypeConverters(Converters::class)
abstract class BancoDeDados: RoomDatabase(){
    abstract fun usuarioDao(): UsuarioDao
    abstract fun topicoDao(): TopicoDao
}
