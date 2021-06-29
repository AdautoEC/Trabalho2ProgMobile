package com.example.trabalho2progmobile.aplicacao.cadastrarTopico

import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.bancoDeDados.topico.repository.ITopicoRepository
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseViewModel

class CadastrarTopicoViewModel(
    private val topicoRepository: ITopicoRepository
    ): BaseViewModel() {

        fun inseriTopico(topico: Topico){
            topicoRepository.inserirTopico(topico)
        }
}