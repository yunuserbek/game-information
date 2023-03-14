package com.example.gameinformation.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.gameinformation.R
import com.example.gameinformation.common.Resource
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailVM>()
   private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getDetail(args.id)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.detailState.collect{
                when(it){
                    is Resource.Loading ->{
                      //  Toast.makeText(requireContext(), "bekleniyor", Toast.LENGTH_SHORT).show()

                         binding.detailProgressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success ->{
                        binding.detailProgressBar.visibility = View.GONE

                        Glide.with(requireContext()).load(it.data.backgroundİmage).into(binding.detailImageView)
                        binding.gameDescriptionText.text = it.data.description
                        binding.gameNameText.text = it.data.header

                    }
                    is Resource.Error ->{
                    }
                }
            }

        }


    }


}