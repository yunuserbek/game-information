package com.example.gameinformation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gameinformation.databinding.HomeItemListBinding
import com.example.gameinformation.features.home.domain.entity.GamesUi

class HomeAdapter() : ListAdapter<GamesUi, HomeAdapter.GamesViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val binding =
            HomeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {

        holder.bind(getItem(position))

    }

    class GamesViewHolder(private val binding: HomeItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GamesUi) {
            with(binding) {

                binding.gameRatingText.text = item.rating.toString()
                binding.gameReleasedText.text = item.released
                binding.gameTitle.text = item.name
                Glide.with(binding.root.context)
                    .load(item.image)
                    .into(binding.gameImage)


            }
        }


    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GamesUi>() {


        override fun areItemsTheSame(oldItem: GamesUi, newItem: GamesUi) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: GamesUi, newItem: GamesUi) =
            oldItem == newItem
    }
}