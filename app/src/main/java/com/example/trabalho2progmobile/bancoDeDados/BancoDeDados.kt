package com.example.trabalho2progmobile.bancoDeDados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.bancoDeDados.usuario.UsuarioDao
import com.example.trabalho2progmobile.utils.converters.Converters

@Database(entities = [Usuario::class], version = 1)
@TypeConverters(Converters::class)
abstract class BancoDeDados: RoomDatabase(){
    abstract fun usuarioDao(): UsuarioDao

    companion object{
        @Volatile
        private var instance: BancoDeDados? = null

        fun getInstance(context: Context): BancoDeDados {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): BancoDeDados {
            return Room.databaseBuilder(context, BancoDeDados::class.java, "bancoDeDados")
                .build()
        }
    }
}
