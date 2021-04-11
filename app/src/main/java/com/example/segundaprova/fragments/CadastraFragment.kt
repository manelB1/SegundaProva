package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.segundaprova.R
import com.example.segundaprova.database.Televisao
import com.example.segundaprova.databinding.FragmentCadastraBinding
import com.example.segundaprova.viewModel.CadastraFragmenViewModel

class CadastraFragment : Fragment() {
    lateinit var binding: FragmentCadastraBinding
    lateinit var viewModel: CadastraFragmenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        viewModel = ViewModelProvider(this).get(CadastraFragmenViewModel::class.java)

        binding.cadastrar.setOnClickListener {
            val televisao = Televisao(
                    binding.nome.text.toString(),
                    binding.cnpj.text.toString(),
                    binding.endereco.text.toString(),
                    binding.cep.text.toString(),
                    binding.razaoSocial.text.toString(),
                    binding.qtdFuncionarios.text.toString().toInt()
            )

            viewModel.cadastra(televisao)
            Navigation.findNavController(it).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment())
        }

        return binding.root
    }
}