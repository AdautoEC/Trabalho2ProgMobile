package com.example.trabalho2progmobile.aplicacao.editarUsuario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.bancoDeDados.usuario.repository.IUsuarioRepository
import com.example.trabalho2progmobile.utils.criptografia.Criptografia
import com.example.trabalho2progmobile.utils.mvvm.abstracts.dadosDoUsuario.AbstractDadosDoUsuarioViewModel
import com.example.trabalho2progmobile.utils.retorno.Resultado

class EditarUsuarioViewModel(
    val usuarioRepository: IUsuarioRepository
): AbstractDadosDoUsuarioViewModel() {

    val usuarioAtualizado: LiveData<Resultado> get() = _usuarioAtualizado
    private val _usuarioAtualizado by lazy { MutableLiveData<Resultado>() }

    val usuario: LiveData<Usuario> get() = _usuario
    private val _usuario by lazy { MutableLiveData<Usuario>() }

    fun atualizarUsuarioNoBanco(usuario: Usuario) {
        usuario.senha = Criptografia.encriptografarMensagem(usuario.senha)
        _usuarioAtualizado.value = Resultado(Resultado.ResultadoStatus.CARREGANDO, false)
        _usuarioAtualizado.value = Resultado(
            Resultado.ResultadoStatus.FINALIZADO,
            usuarioRepository.atualizarUsuario(usuario)
        )
    }

    fun buscarUsuario(usuario: Usuario){
        _usuario.value = usuarioRepository.buscarUsuarioPeloEmail(usuario.email)
    }
}