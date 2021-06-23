package com.example.trabalho2progmobile.aplicacao.cadastro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.bancoDeDados.usuario.repository.IUsuarioRepository
import com.example.trabalho2progmobile.utils.mvvm.BaseViewModel
import com.example.trabalho2progmobile.utils.retorno.Resultado

class CadastrarViewModel(
    val usuarioRepository: IUsuarioRepository
): BaseViewModel() {

    val erroNome: LiveData<Int> get() = _erroNome
    private val _erroNome by lazy { MutableLiveData<Int>() }

    val erroEmail: LiveData<Int> get() = _erroEmail
    private val _erroEmail by lazy { MutableLiveData<Int>() }

    val erroSenha: LiveData<Int> get() = _erroSenha
    private val _erroSenha by lazy { MutableLiveData<Int>() }

    val erroConfirmarSenha: LiveData<Int> get() = _erroConfirmarSenha
    private val _erroConfirmarSenha by lazy { MutableLiveData<Int>() }

    val dadosCorretos: LiveData<Boolean> get() = _dadosCorretos
    private val _dadosCorretos by lazy { MutableLiveData<Boolean>() }

    val usuarioInserido: LiveData<Resultado> get() = _usuarioInserido
    private val _usuarioInserido by lazy { MutableLiveData<Resultado>() }

    fun verificarCampo(
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

    private fun verificarEmail(email: String): Boolean{
        return if(email.isNotEmpty()) true
        else {
            _erroEmail.value = R.string.erro_email_vazio
            false
        }
    }

    private fun verificarSenhas(senha: String, confirmacaoDeSenha: String): Boolean{
        return if(senha.isNotEmpty() && confirmacaoDeSenha.isNotEmpty()) {
            if(senha == confirmacaoDeSenha){
                true
            }
            else{
                _erroConfirmarSenha.value = R.string.erro_confirmar_senha
                false
            }
        }
        else {
            if(senha.isEmpty())_erroSenha.value = R.string.erro_senha_vazia
            else _erroConfirmarSenha.value = R.string.erro_confirmar_senha
            false
        }
    }
}