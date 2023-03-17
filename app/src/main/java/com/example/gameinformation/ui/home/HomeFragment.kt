package com.example.gameinformation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.gameinformation.R
import com.example.gameinformation.collectInResumed
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.FragmentHomeBinding
import com.example.gameinformation.databinding.SearchBarBinding
import com.example.gameinformation.ui.adapter.HomeAdapter
import com.example.gameinformation.ui.adapter.StoresAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding



   // private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<HomeVM>()
    private val gamesAdapter by lazy { HomeAdapter() }
    private val storeAdapter by lazy { StoresAdapter() }
    private lateinit var toolbarBinding: SearchBarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        toolbarBinding = SearchBarBinding.bind(binding.root)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectData()
        getData()
        //getStoreData()
        searchQueryListen()

    }

    private fun searchQueryListen() {

        toolbarBinding.svSearchGame.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchGames(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
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
            binding.gameRv.adapter = storeAdapter
        }
    }

    private fun searchGames(query: String) {
        viewModel.searchGame(query)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.searchGame.collect { state ->
                    state?.let {
                        gamesAdapter.submitData(state)
                    }
                }
            }
        }
    }
}