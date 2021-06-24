package com.example.trabalho2progmobile.aplicacao.cadastro

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.utils.converters.Converters
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseFragment
import com.example.trabalho2progmobile.utils.retorno.Resultado
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cadastrar_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CadastrarFragment: BaseFragment() {
    private val REQUEST_IMAGE_CAPTURE = 1
    private val _viewModel: CadastrarViewModel by viewModel()
    var foto: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastrar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().toolbar.setTitle(R.string.cadastrar)
        setupUi()
        subscribeUi()
    }

    private fun setupUi(){
        btn_cadastrar.setOnClickListener {
            _viewModel.verificarCampos(
                input_nome_completo.text.toString(),
                input_email.text.toString(),
                input_password.text.toString(),
                input_confirm_password.text.toString()
            )
        }
        imgViewFoto.setOnClickListener {
            capturePhoto()
        }
    }

    private fun subscribeUi(){
        _viewModel.erroNome.observe(viewLifecycleOwner) {
            mostrarErroDoMaskEditText(input_nome_completo, it)
        }
        _viewModel.erroEmail.observe(viewLifecycleOwner) {
            mostrarErroDoMaskEditText(input_email, it)
        }
        _viewModel.erroSenha.observe(viewLifecycleOwner) {
            mostrarErroDoMaskEditText(input_password, it)
        }
        _viewModel.erroConfirmarSenha.observe(viewLifecycleOwner) {
            mostrarErroDoMaskEditText(input_confirm_password, it)
        }
        _viewModel.dadosCorretos.observe(viewLifecycleOwner) {
            if(it)
            _viewModel.inserirUsuarioNoBanco(
                Usuario(
                    0,
                    input_nome_completo.text.toString(),
                    input_email.text.toString(),
                    input_password.text.toString(),
                    verificarSeEFotoOuDrawable()
                )
            )
        }
        _viewModel.usuarioInserido.observe(viewLifecycleOwner, ::processarResultado)
    }

    private fun processarResultado(
        resultado: Resultado
    ){
        if(resultado.resultadoStatus == Resultado.ResultadoStatus.CARREGANDO){
            opcoesDialog(R.string.dialog_mostrar, R.string.salvando_usuario)
        }
        else{
            if(resultado.correto){
                opcoesDialog(R.string.dialog_remover, R.string.salvando_usuario)
                exibirMensagem(getString(R.string.usuario_inserido))
                findNavController().popBackStack()
            }
            else{
                opcoesDialog(R.string.dialog_remover, R.string.salvando_usuario)
                exibirMensagem(getString(R.string.erro_inserir_usuario))
            }
        }
    }

    private fun capturePhoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(requireActivity().packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            foto = imageBitmap
            imgViewFoto.setImageBitmap(Converters().getRoundedCornerBitmap(imageBitmap, 360))
        }
    }

    private fun verificarSeEFotoOuDrawable(): Bitmap{
        return if(foto != null){
            foto as Bitmap
        } else{
            Converters().drawableToBitmap(
                requireContext().getDrawable(R.drawable.ic_foto)!!
            )
        }
    }
}