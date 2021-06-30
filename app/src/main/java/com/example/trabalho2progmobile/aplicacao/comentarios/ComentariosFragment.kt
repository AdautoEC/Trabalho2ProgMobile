package com.example.trabalho2progmobile.aplicacao.comentarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.trabalho2progmobile.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.comentarios_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComentariosFragment : Fragment() {

    private val _viewModel: ComentariosViewModel by viewModel()
    private val args: ComentariosFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.comentarios_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        requireActivity().toolbar.setTitle(R.string.comentarios)
        super.onActivityCreated(savedInstanceState)
        setTopicoText()
    }

    fun setTopicoText(){
        txt_nome_topico.setText(args.topico.nome);
        txt_hora_topico.setText(args.topico.hora);
        txt_descricao_topico.setText(args.topico.descricao);
    }

    private fun setupUi() {

    }

}