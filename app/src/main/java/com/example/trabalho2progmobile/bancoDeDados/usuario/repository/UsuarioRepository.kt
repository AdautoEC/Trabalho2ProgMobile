package com.example.trabalho2progmobile.bancoDeDados.usuario.repository

import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.bancoDeDados.usuario.UsuarioDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UsuarioRepository(
    private val usuarioDao: UsuarioDao
): IUsuarioRepository{
    override fun inserirUsuario(usuario: Usuario){
        CoroutineScope(IO).launch {
            usuarioDao.inserirUsuario(usuario)
        }
    }

    override fun buscarUsuarios(): List<Usuario> = runBlocking{
        return@runBlocking usuarioDao.getAllUsuarios()
    }

    override fun buscarUsuarioPeloId(usuarioId: Int): Usuario = runBlocking{
        return@runBlocking usuarioDao.getUsuarioById(usuarioId)
    }

    override fun atualizarUsuario(usuario: Usuario){
        CoroutineScope(IO).launch {
            usuarioDao.updateUsuario(usuario)
        }
    }

    override fun deletarUsuario(usuario: Usuario){
        CoroutineScope(IO).launch {
            usuarioDao.deleteUsuario(usuario)
        }
    }
}