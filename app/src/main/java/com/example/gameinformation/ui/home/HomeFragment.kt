package com.example.gameinformation.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gameinformation.R
import com.example.gameinformation.collectInResumed
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.FragmentHomeBinding
import com.example.gameinformation.ui.adapter.HomeAdapter
import com.example.gameinformation.ui.adapter.StoresAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {


    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<HomeVM>()
    private val gamesAdapter by lazy { HomeAdapter() }
    private val storeAdapter by lazy { StoresAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectData()
        getData()
        //getStoreData()

    }

    fun collectData(){
        gamesAdapter.onclick={
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.idUse!!)
            findNavController().navigate(action)
        }
        storeAdapter.onclickstore={
            val action = HomeFragmentDirections.actionHomeFragmentToStoresDetailFragment(it.id!!)
            findNavController().navigate(action)
        }
    }

    private fun getData() = viewLifecycleOwner.lifecycleScope.launch {

        viewModel.gameState.collectInResumed(viewLifecycleOwner) {
            binding.gameRv.adapter = gamesAdapter
            gamesAdapter.submitData(lifecycle,it)

        }

    }

    private fun getStoreData() = viewLifecycleOwner.lifecycleScope.launch {

        viewModel.storeState.collect {
            storeAdapter.updateList(it)
            binding.gameRv.adapter= storeAdapter
        }
    }

}