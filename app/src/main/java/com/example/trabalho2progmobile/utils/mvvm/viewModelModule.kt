package com.example.trabalho2progmobile.utils.mvvm

import com.example.trabalho2progmobile.aplicacao.cadastro.CadastrarViewModel
import com.example.trabalho2progmobile.aplicacao.inicial.InicialViewModel
import com.example.trabalho2progmobile.aplicacao.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        InicialViewModel()
    }

    viewModel {
        LoginViewModel()
    }

    viewModel {
        CadastrarViewModel()
    }
}
