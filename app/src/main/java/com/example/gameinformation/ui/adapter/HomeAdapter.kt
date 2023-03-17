package com.example.gameinformation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gameinformation.R
import com.example.gameinformation.common.extension.glideImage
import com.example.gameinformation.databinding.HomeItemListBinding
import com.example.gameinformation.features.home.domain.entity.GamesUi

class HomeAdapter() : PagingDataAdapter<GamesUi, HomeAdapter.GamesViewHolder>(DiffCallback) {
    var onclick: (GamesUi) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val binding =
            HomeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {

        getItem(position)?.let { holder.bind(it) }

    }

   inner class GamesViewHolder(private val binding: HomeItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GamesUi) {
            with(binding) {

                binding.root.setOnClickListener {
                    onclick(item)
                }

              binding.imageViewGame.glideImage(item.image)
                binding.reportContent.text= item.name






            }
        }


    }



    companion object DiffCallback : DiffUtil.ItemCallback<GamesUi>() {


        override fun areItemsTheSame(oldItem: GamesUi, newItem: GamesUi) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: GamesUi, newItem: GamesUi) =
            oldItem == newItem
    }
}