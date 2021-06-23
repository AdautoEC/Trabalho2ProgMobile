package com.example.trabalho2progmobile.bancoDeDados.usuario.repository

import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario

interface IUsuarioRepository {
    fun inserirUsuario(usuario: Usuario)
    fun buscarUsuarios(): List<Usuario>
    fun buscarUsuarioPeloId(usuarioId: Int): Usuario
    fun atualizarUsuario(usuario: Usuario)
    fun deletarUsuario(usuario: Usuario)
}