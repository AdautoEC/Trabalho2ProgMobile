package com.example.trabalho2progmobile.bancoDeDados.topico.repository

import com.example.trabalho2progmobile.bancoDeDados.topico.Topico

interface ITopicoRepository {
    suspend fun inserirTopico(topico: Topico): Boolean
    suspend fun buscarTopicos(): List<Topico>
    suspend fun buscarTopicoPeloId(topicoId: Int): Topico
    suspend fun deletarTopico(topico: Topico): Boolean
}