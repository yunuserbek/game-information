package com.example.gameinformation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameinformation.databinding.ItemLastSearchedBinding
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel

class LastSearchedAdapter(

) : RecyclerView.Adapter<LastSearchedAdapter.LastViewHolder>() {
    private val words: ArrayList<String> = ArrayList()
    var onWordClick: ((String) -> Unit) = {}




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastViewHolder =
        LastViewHolder(
            ItemLastSearchedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int =words.size

    override fun onBindViewHolder(holder: LastViewHolder, position: Int) {
        holder.bind(words[position])
    }
    inner class LastViewHolder(private val binding: ItemLastSearchedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(word: String) {
            binding.root.setOnClickListener { onWordClick(word) }
            binding.textWord.text = word
        }

    }

    fun lastList(updateList: List<String>) {
        this.words.clear()
        this.words.addAll(updateList)
        notifyItemRangeInserted(0, updateList.size)
    }


}