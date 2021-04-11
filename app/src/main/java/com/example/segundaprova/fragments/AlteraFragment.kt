package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentAlteraBinding
import com.example.segundaprova.viewModel.AlteraFragmentViewModel
import com.example.segundaprova.viewModel.CadastraFragmenViewModel

class AlteraFragment : Fragment() {
    lateinit var binding: FragmentAlteraBinding
    lateinit var viewModel: AlteraFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewModel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java)

        val args: AlteraFragmentArgs by navArgs()

        var televisao = viewModel.findById(args.id)

        binding.nomePrograma.setText(televisao.nome)
        binding.canalPrograma.setText(televisao.canal)
        binding.classificacaoPrograma.setText(televisao.classificacao)
        binding.diretorPrograma.setText((televisao.diretor))
        binding.descricaoPrograma.setText(televisao.descricao)
        binding.anoPrograma.setText(televisao.ano.toString())

        televisao.ano = binding.anoPrograma.text.toString().toInt()
        televisao.id = args.id.toInt()

        binding.editar.setOnClickListener {
            televisao.ano = binding.anoPrograma.text.toString().toInt()
            televisao.id = args.id.toInt()

            viewModel.atualizar(televisao)
            Navigation.findNavController(it).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}