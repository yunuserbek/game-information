package com.example.gameinformation.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.gameinformation.R
import com.example.gameinformation.common.Resource
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.FragmentDetailBinding
import com.example.gameinformation.databinding.FragmentHomeBinding
import com.example.gameinformation.ui.home.HomeVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailVM>()
    private var id:String?=null
   private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getDetail(args.id)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.detailState.collect{
                when(it){
                    is Resource.Loading ->{
                        Toast.makeText(requireContext(), "bekleniyor", Toast.LENGTH_SHORT).show()

                        // binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success ->{
                        //binding.progressBar.visibility = View.GONE
                        binding.textid.text =it.data.date
                        Glide.with(requireContext()).load(it.data.backgroundİmage).into(binding.image)

                    }
                    is Resource.Error ->{
                    }
                }
            }

        }


    }


}