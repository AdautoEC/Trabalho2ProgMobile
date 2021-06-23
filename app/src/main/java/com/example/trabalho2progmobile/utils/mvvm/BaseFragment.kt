package com.example.trabalho2progmobile.utils.mvvm

import androidx.fragment.app.Fragment
import com.example.trabalho2progmobile.utils.mensagens.MensagemUtils.Companion.mostrarMensagem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseFragment: Fragment() {
    fun exibirMensagemDeErro(mensagem: String) {
        CoroutineScope(Dispatchers.Main).launch {
            mostrarMensagem(requireContext(), mensagem)
        }
    }
}