package com.example.trabalho2progmobile.bancoDeDados.usuario

import androidx.room.*

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuario")
    suspend fun getAllUsuarios(): List<Usuario>

    @Query("SELECT * FROM usuario WHERE usuarioId == :usuarioId")
    suspend fun getUsuarioById(usuarioId: Int): Usuario

    @Update
    suspend fun updateUsuario(usuario: Usuario)

    @Delete
    suspend fun deleteUsuario(usuario: Usuario)
}