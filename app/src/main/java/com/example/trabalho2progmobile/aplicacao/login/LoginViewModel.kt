package com.example.trabalho2progmobile.aplicacao.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.utils.mvvm.abstracts.dadosDoUsuario.AbstractDadosDoUsuarioViewModel

class LoginViewModel : AbstractDadosDoUsuarioViewModel() {
    val dadosCorretos: LiveData<Boolean> get() = _dadosCorretos
    private val _dadosCorretos by lazy { MutableLiveData<Boolean>() }

    fun verificarCampos(
        email: String,
        senha: String
    ){
        val verificarEmail = verificarEmail(email)
        val verificarSenhas = verificarSenha(senha)

        _dadosCorretos.value = verificarEmail && verificarSenhas
    }

    private fun verificarSenha(senha: String): Boolean{
        return if(senha.isNotEmpty()) true
        else {
            _erroSenha.value = R.string.erro_senha_vazia
            false
        }
    }
}