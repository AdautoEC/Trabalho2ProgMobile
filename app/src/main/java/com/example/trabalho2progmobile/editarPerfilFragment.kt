package com.example.trabalho2progmobile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class editarPerfilFragment : Fragment() {

    companion object {
        fun newInstance() = editarPerfilFragment()
    }

    private lateinit var viewModel: EditarPerfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.editar_perfil_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditarPerfilViewModel::class.java)
        // TODO: Use the ViewModel
    }

}