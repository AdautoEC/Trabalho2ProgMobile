package com.example.trabalho2progmobile.aplicacao.topicos

import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.bancoDeDados.topico.repository.ITopicoRepository
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TopicosViewModel (val topicoRepository: ITopicoRepository) : BaseViewModel() {

    fun listarTopicos(): List<Topico> = runBlocking{
        return@runBlocking topicoRepository.buscarTopicos()
    }

    fun inserirTopico() {
        CoroutineScope(Dispatchers.IO).launch {
            topicoRepository.inserirTopico(
                Topico(
                    nome="nome do topico",
                    hora = "28/06/2021 16:40",
                    descricao = "descrição do topico"
                )
            )
        }
    }
}