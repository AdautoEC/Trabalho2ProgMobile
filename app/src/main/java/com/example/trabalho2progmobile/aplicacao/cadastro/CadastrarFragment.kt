package com.example.trabalho2progmobile.aplicacao.cadastro

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.utils.mvvm.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cadastrar_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CadastrarFragment: BaseFragment() {

    private val REQUEST_CODE = 200
    private val _viewModel: CadastrarViewModel by viewModel()

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
            _viewModel.verificarCampo(
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
    }

    private fun mostrarErroDoMaskEditText(editText: TextInputEditText, erro: Int){
        editText.error = getString(erro)
    }

    private fun capturePhoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){
            imgViewFoto.setImageBitmap(data.extras!!.get("data") as Bitmap)
        }
    }
}