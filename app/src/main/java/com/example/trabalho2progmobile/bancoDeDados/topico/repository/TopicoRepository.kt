package com.example.trabalho2progmobile.bancoDeDados.topico.repository

import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.bancoDeDados.topico.TopicoDao
import kotlinx.coroutines.runBlocking

class TopicoRepository(
    private val topicoDao: TopicoDao
): ITopicoRepository{
    override suspend fun inserirTopico(topico: Topico): Boolean = runBlocking{
        return@runBlocking try {
            topicoDao.inserirTopico(topico)
            true
        }
        catch (e:Exception){
            false
        }
    }

    override suspend fun buscarTopicos(): List<Topico> = runBlocking{
        return@runBlocking topicoDao.getAllTopicos()
    }

    override suspend fun buscarTopicoPeloId(id: Int): Topico = runBlocking{
        return@runBlocking topicoDao.getTopicoById(id)
    }

    override suspend fun deletarTopico(topico: Topico): Boolean = runBlocking{
        return@runBlocking try {
            topicoDao.deleteTopico(topico)
            true
        }
        catch (e:Exception){
            false
        }
    }
}