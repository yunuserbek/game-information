package com.example.gameinformation.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gameinformation.R
import com.example.gameinformation.common.Resource
import com.example.gameinformation.common.addSnap
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.FragmentHomeBinding
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.ui.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {


    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<HomeVM>()
    private val gamesAdapter by lazy { HomeAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectData()
        getData()

    }

    fun collectData(){
        gamesAdapter.onclick={
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.idUse!!)
            findNavController().navigate(action)
        }
    }
    private fun getData() =viewLifecycleOwner.lifecycleScope.launch {
        viewModel.homestate.collect{
            binding.gameRv.adapter = gamesAdapter
            gamesAdapter.submitList(it)

        }
    }

}