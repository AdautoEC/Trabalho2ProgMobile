package com.example.trabalho2progmobile.aplicacao.topicos
import android.view.View
import com.example.trabalho2progmobile.bancoDeDados.topico.Topico

interface ITopicosRecyclerViewClickListener {
    fun onTopicosRecyclerViewItemClickListener(view: View, produto: Topico)
}
