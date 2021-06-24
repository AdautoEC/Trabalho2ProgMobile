package com.example.trabalho2progmobile.aplicacao.cadastro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.bancoDeDados.usuario.repository.IUsuarioRepository
import com.example.trabalho2progmobile.utils.retorno.Resultado
import com.example.trabalho2progmobile.utils.mvvm.abstracts.dadosDoUsuario.AbstractDadosDoUsuarioViewModel

class CadastrarViewModel(
    val usuarioRepository: IUsuarioRepository
): AbstractDadosDoUsuarioViewModel() {

    val erroNome: LiveData<Int> get() = _erroNome
    private val _erroNome by lazy { MutableLiveData<Int>() }

    val dadosCorretos: LiveData<Boolean> get() = _dadosCorretos
    private val _dadosCorretos by lazy { MutableLiveData<Boolean>() }

    val usuarioInserido: LiveData<Resultado> get() = _usuarioInserido
    private val _usuarioInserido by lazy { MutableLiveData<Resultado>() }

    fun verificarCampos(
        nome: String,
        email: String,
        senha: String,
        confirmacaoDeSenha: String
    ){
        val verificarNome = verificarNome(nome)
        val verificarEmail = verificarEmail(email)
        val verificarSenhas = verificarSenhas(senha, confirmacaoDeSenha)

        _dadosCorretos.value = verificarNome && verificarEmail && verificarSenhas
    }

    fun inserirUsuarioNoBanco(usuario: Usuario){
        _usuarioInserido.value = Resultado(Resultado.ResultadoStatus.CARREGANDO, false)
        _usuarioInserido.value = Resultado(
            Resultado.ResultadoStatus.FINALIZADO,
            usuarioRepository.inserirUsuario(usuario)
        )
    }

    private fun verificarNome(nome: String): Boolean{
        return if(nome.isNotEmpty()) true
        else {
            _erroNome.value = R.string.erro_nome_vazio
            false
        }
    }
}