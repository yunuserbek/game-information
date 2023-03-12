package com.example.gameinformation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameinformation.R
import com.example.gameinformation.common.delegation.viewBinding
import com.example.gameinformation.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {


  private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}