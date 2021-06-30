package com.example.trabalho2progmobile.aplicacao.comentarios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trabalho2progmobile.bancoDeDados.comentario.Comentario
import com.example.trabalho2progmobile.bancoDeDados.comentario.repository.IComentarioRepository
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.bancoDeDados.usuario.repository.IUsuarioRepository
import com.example.trabalho2progmobile.utils.comentarioComUsuario.ComentarioComUsuario
import com.example.trabalho2progmobile.utils.retorno.Resultado
import kotlinx.coroutines.runBlocking

class ComentariosViewModel(
    private val comentarioRepository: IComentarioRepository,
    private val usuarioRepository: IUsuarioRepository
): ViewModel() {

    val comentarioInserido: LiveData<Resultado> get() = _comentarioInserido
    private val _comentarioInserido by lazy { MutableLiveData<Resultado>() }

    fun verificarComentario(comentario: String): Boolean{
        return comentario.isNotEmpty()
    }

    fun inserirComentario(comentario: Comentario){
        _comentarioInserido.value = Resultado(Resultado.ResultadoStatus.CARREGANDO, false)
        _comentarioInserido.value = Resultado(
            Resultado.ResultadoStatus.FINALIZADO,
            comentarioRepository.inserirComentario(comentario)
        )
    }

    fun listarComentarios(topicoId: Int): List<Comentario> = runBlocking{
        return@runBlocking comentarioRepository.buscarComentarios(topicoId)
    }

    private fun buscarUsuarioDoComentario(usuarioId: Int): Usuario = runBlocking{
        return@runBlocking usuarioRepository.buscarUsuarioPeloId(usuarioId)
    }

    fun integrarUsuariosComComentarios(listaDeComentarios: List<Comentario>): List<ComentarioComUsuario>{
        val listaDeComentariosComUsuario: MutableList<ComentarioComUsuario> = mutableListOf()

        listaDeComentarios.forEach {
            listaDeComentariosComUsuario.add(
                ComentarioComUsuario(
                    it,
                    buscarUsuarioDoComentario(it.usuarioId)
                )
            )
        }

        return listaDeComentariosComUsuario
    }

}