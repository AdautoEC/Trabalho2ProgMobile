package com.example.trabalho2progmobile.aplicacao.cadastrarTopico

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.bancoDeDados.topico.Topico
import com.example.trabalho2progmobile.utils.dataHora.DataHora.Companion.gerarDataHora
import kotlinx.android.synthetic.main.cadastrar_topico_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CadastrarTopicoFragment : Fragment() {

    private val _viewModel: CadastrarTopicoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastrar_topico_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUi()
    }

    private fun subscribeUi(){
        btn_cadastrar_Topico.setOnClickListener {
            _viewModel.inseriTopico(
                Topico(
                    nome = input_nome_topico.text.toString(),
                    hora = gerarDataHora(),
                    descricao = input_descricao.text.toString(),
                )
            )
        }
    }
}