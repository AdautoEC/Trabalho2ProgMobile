package com.example.trabalho2progmobile.utils.mvvm

import androidx.room.Room
import com.example.trabalho2progmobile.aplicacao.cadastro.CadastrarViewModel
import com.example.trabalho2progmobile.aplicacao.inicial.InicialViewModel
import com.example.trabalho2progmobile.aplicacao.login.LoginViewModel
import com.example.trabalho2progmobile.bancoDeDados.BancoDeDados
import com.example.trabalho2progmobile.bancoDeDados.usuario.UsuarioDao
import com.example.trabalho2progmobile.bancoDeDados.usuario.repository.IUsuarioRepository
import com.example.trabalho2progmobile.bancoDeDados.usuario.repository.UsuarioRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    single<BancoDeDados>{
        Room.databaseBuilder(androidApplication(), BancoDeDados::class.java, "bandoDeDados")
            .build()
    }

    single<UsuarioDao>{
        get<BancoDeDados>().usuarioDao()
    }

    single<IUsuarioRepository>{
        UsuarioRepository(
            usuarioDao = get()
        )
    }

    viewModel {
        InicialViewModel()
    }

    viewModel {
        LoginViewModel(
            usuarioRepository = get()
        )
    }

    viewModel {
        CadastrarViewModel(
            usuarioRepository = get()
        )
    }
}
