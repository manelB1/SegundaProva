package com.example.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundaprova.R
import com.example.segundaprova.adapters.TelevisaoAdapter
import com.example.segundaprova.adapters.MyRecyclerViewClickListener
import com.example.segundaprova.databinding.FragmentHomeBinding
import com.example.segundaprova.viewModel.HomeFragmentViewModel

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var layout: LinearLayoutManager
    var televisaoAdapter = TelevisaoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        layout = LinearLayoutManager(parentFragment?.requireContext(), LinearLayoutManager.VERTICAL, false)

        viewModel.lista?.observe(viewLifecycleOwner, {
            televisaoAdapter.televisaos = it
            televisaoAdapter.notifyDataSetChanged()
        })

        setHasOptionsMenu(true);

        binding.recyclerView.addOnItemTouchListener(
            MyRecyclerViewClickListener(requireContext(),  binding.recyclerView,
            object : MyRecyclerViewClickListener.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(televisaoAdapter.televisaos[position].id.toLong()));
                }

                override fun onItemLongClick(view: View, position: Int) {
                    Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(televisaoAdapter.televisaos[position].id.toLong()));
                }
            })
        )

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = televisaoAdapter
        binding.recyclerView.layoutManager = layout
    }
}