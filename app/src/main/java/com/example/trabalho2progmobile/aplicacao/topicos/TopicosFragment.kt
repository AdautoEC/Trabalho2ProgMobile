package com.example.trabalho2progmobile.aplicacao.topicos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.trabalho2progmobile.R
import com.example.trabalho2progmobile.utils.mvvm.abstracts.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopicosFragment: BaseFragment() {
    private val _viewModel: TopicosViewModel by viewModel()
    private val args: TopicosFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.topicos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().toolbar.setTitle(R.string.topicos)
        print(args.usuario)
    }

}