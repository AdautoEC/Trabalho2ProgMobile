package com.example.trabalho2progmobile.aplicacao.comentarios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.aplicacao.comentarios.adapter.ComentariosAdapter
import com.example.trabalho2progmobile.bancoDeDados.comentario.Comentario
import com.example.trabalho2progmobile.utils.dataHora.DataHora.Companion.gerarDataHora
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseFragment
import com.example.trabalho2progmobile.utils.retorno.Resultado
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.comentarios_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComentariosFragment: BaseFragment() {

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
        setupUi()
        subscribeUi()
        criarRecylerView()
    }

    fun setTopicoText(){
        txt_nome_topico.text = args.topico.nome;
        txt_hora_topico.text = args.topico.hora;
        txt_descricao_topico.text = args.topico.descricao;
    }

    private fun setupUi() {
        btn_postar_comentario.setOnClickListener {
            if(_viewModel.verificarComentario(input_cadastrar_comentario.text.toString())){
                _viewModel.inserirComentario(
                    Comentario(
                        text = input_cadastrar_comentario.text.toString(),
                        dataHora = gerarDataHora(),
                        usuarioId = args.usuario.usuarioId,
                        topicoId = args.topico.topicoId
                    )
                )
            }
            else{
                mostrarErroDoTextInputLayout(textInputLayoutComentario, R.string.erro_comentario)
            }
        }
    }

    private fun subscribeUi(){
        _viewModel.comentarioInserido.observe(viewLifecycleOwner, ::processarResultado)
    }

    private fun processarResultado(
        resultado: Resultado
    ){
        if(resultado.resultadoStatus == Resultado.ResultadoStatus.CARREGANDO){
            opcoesDialog(R.string.dialog_mostrar, R.string.salvando_comentario)
        }
        else{
            if(resultado.correto){
                opcoesDialog(R.string.dialog_remover, R.string.salvando_comentario)
                exibirMensagem(getString(R.string.comentario_inserido))
//                findNavController().popBackStack()
            }
            else{
                opcoesDialog(R.string.dialog_remover, R.string.salvando_comentario)
                exibirMensagem(getString(R.string.comentario_inserido))
            }
        }
    }

    private fun criarRecylerView(){
        val listaDeComentarios = _viewModel.listarComentarios(args.topico.topicoId)
        val listaDeComentariosComUsuario = _viewModel.integrarUsuariosComComentarios(listaDeComentarios)
        recyclerViewComentarios.also{
            it.layoutManager = GridLayoutManager(requireContext(), 1)
            it.setHasFixedSize(true)
            it.adapter = ComentariosAdapter(listaDeComentariosComUsuario)
        }
    }

}