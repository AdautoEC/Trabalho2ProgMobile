package com.example.trabalho2progmobile.aplicacao.cadastrarTopico

import androidx.lifecycle.ViewModel
import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.bancoDeDados.topico.repository.ITopicoRepository
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseViewModel
import kotlinx.coroutines.runBlocking

class CadastrarTopicoViewModel (val topicoRepository: ITopicoRepository) : BaseViewModel() {
    fun inserirTopico(topico: Topico) = runBlocking{
        return@runBlocking topicoRepository.inserirTopico(topico)
    }
}