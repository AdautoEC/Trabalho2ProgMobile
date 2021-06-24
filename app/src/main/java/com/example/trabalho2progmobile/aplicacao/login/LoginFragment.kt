package com.example.trabalho2progmobile.aplicacao.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.bancoDeDados.usuario.Usuario
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cadastrar_fragment.*
import kotlinx.android.synthetic.main.login_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: BaseFragment() {
    private val _viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().toolbar.setTitle(R.string.login)
        setupUi()
        subscribeUi()
    }

    private fun setupUi(){
        btn_logar.setOnClickListener {
            _viewModel.verificarCampos(
                input_email_login.text.toString(),
                input_password_login.text.toString()
            )
        }
    }

    private fun subscribeUi(){
        _viewModel.erroEmail.observe(viewLifecycleOwner) {
            mostrarErroDoMaskEditText(input_email_login, it)
        }
        _viewModel.erroSenha.observe(viewLifecycleOwner) {
            mostrarErroDoMaskEditText(input_password_login, it)
        }
        _viewModel.dadosCorretos.observe(viewLifecycleOwner) {
            if(it)
                print("a")
        }
    }

}