package com.project.coroutines_koin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.project.coroutines_koin.R
import com.project.coroutines_koin.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MainFragment : Fragment() {



    private val viewModel: MainViewModel by viewModel{
        parametersOf(findNavController())
    }
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<MainFragmentBinding>(
            inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.filmesLiveData.observe(viewLifecycleOwner, Observer{ filmes ->
            binding.textViewFilmes.text = filmes[1].titulo
        })
        viewModel.getFimesCoroutines()
    }

}