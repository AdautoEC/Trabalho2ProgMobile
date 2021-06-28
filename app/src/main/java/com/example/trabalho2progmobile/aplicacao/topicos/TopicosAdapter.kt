package com.example.trabalho2progmobile.aplicacao.topicos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.databinding.TopicoFragmentBinding

class TopicosAdapter(
    private val topicos: List<Topico>,
    private val listenerIProdutos: ITopicosRecyclerViewClickListener
): RecyclerView.Adapter<TopicosAdapter.TopicosViewHolder>() {

    inner class TopicosViewHolder(
        val recyclerviewTopicoBinding: TopicoFragmentBinding
    ): RecyclerView.ViewHolder(recyclerviewTopicoBinding.root)

    override fun getItemCount() = topicos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopicosViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.topicos_fragment,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TopicosViewHolder, position: Int) {
        holder.recyclerviewTopicoBinding.topico = topicos[position]

        holder.recyclerviewTopicoBinding.root.setOnClickListener {
            listenerIProdutos.onTopicosRecyclerViewItemClickListener(
                holder.recyclerviewTopicoBinding.root,
                topicos[position]
            )
        }
    }
}