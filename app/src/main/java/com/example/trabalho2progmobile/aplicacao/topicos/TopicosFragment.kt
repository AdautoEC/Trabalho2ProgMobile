package com.example.trabalho2progmobile.aplicacao.topicos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.topicos_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopicosFragment: BaseFragment(), ITopicosRecyclerViewClickListener {
    private val _viewModel: TopicosViewModel by viewModel()
//    private val args: TopicosFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.topicos_fragment, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().toolbar.setTitle(R.string.topicos)
        setupUi()
        _viewModel.inserirTopico()
        criarRecylerView()
    }

    private fun criarRecylerView(){
        val listaDeTopicos = _viewModel.listarTopicos()
        recyclerViewTopicos.also{
            it.layoutManager = GridLayoutManager(requireContext(), 1)
            it.setHasFixedSize(true)
            it.adapter = TopicosAdapter(listaDeTopicos, this)
        }
    }

    private fun setupUi(){

    }

    override fun onTopicosRecyclerViewItemClickListener(view: View, produto: Topico) {

    }

}