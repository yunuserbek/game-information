package com.example.gameinformation.ui.storedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.gameinformation.R
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.StoresDetailBinding
import com.example.gameinformation.ui.detail.DetailFragmentArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoresDetailFragment : Fragment(R.layout.stores_detail) {
    private val binding by viewBinding(StoresDetailBinding::bind)
    private val viewModel by viewModels<StoresVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getStoresDetail()
    }
    fun getStoresDetail() =viewLifecycleOwner.lifecycleScope.launch{
        viewModel.storesData.collect{
            binding.gameNameText.text =it.name
            Glide.with(requireContext()).load(it.imageBackground).into(binding.detailImageView)
            binding.gameDescriptionText.text =it.description
        }

    }

}