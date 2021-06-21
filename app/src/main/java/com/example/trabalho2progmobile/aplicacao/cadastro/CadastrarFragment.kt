package com.example.trabalho2progmobile.aplicacao.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.utils.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CadastrarFragment: BaseFragment() {

    private val _viewModel: CadastrarViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastrar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}