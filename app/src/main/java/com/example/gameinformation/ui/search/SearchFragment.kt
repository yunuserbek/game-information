package com.example.gameinformation.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gameinformation.R
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.FragmentSearchBinding
import com.example.gameinformation.ui.adapter.HomeAdapter
import com.example.gameinformation.ui.adapter.LastSearchedAdapter
import com.example.gameinformation.ui.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
    private val gamesAdapter by lazy { HomeAdapter() }

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel by viewModels<SearchVM>()
    private val lastAdapter by lazy { LastSearchedAdapter() }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        searchQueryListen()
        getLastData()
        lastWordClick()

    }
     private fun searchQueryListen() {

         binding.svSearchGame.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
             override fun onQueryTextSubmit(query: String): Boolean {
                 searchGames(query)
                 return false
             }

             override fun onQueryTextChange(newText: String): Boolean {
                 return false
             }
         })
     }
    fun getLastData() = viewLifecycleOwner.lifecycleScope.launch {

        viewModel.lastSearchedWordsState.collect {
            lastAdapter.lastList(it)
            binding.lastRv.adapter = lastAdapter
        }
    }
    private fun searchGames(query: String) {
        viewModel.searchGame(query)

            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.searchGame.collect { state ->
                    state?.let {
                        binding.searchRv.adapter =gamesAdapter
                        gamesAdapter.submitData(state)

                    }
                }
            }
        gamesAdapter.onclick={
            val action = SearchFragmentDirections.actionSearchFragmentToStoresDetailFragment(it.idUse?:0)
            findNavController().navigate(action)
        }
        }




    fun lastWordClick(){
     lastAdapter.onWordClick ={
         searchGames(it)

     }
 }


}