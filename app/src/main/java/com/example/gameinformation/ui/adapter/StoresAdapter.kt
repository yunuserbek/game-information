package com.example.gameinformation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gameinformation.databinding.StoreItemListBinding
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel

class StoresAdapter : RecyclerView.Adapter<StoresAdapter.StoresViewHolder>() {
    private val list = ArrayList<StoreUIModel>()

    var onclickstore: ((StoreUIModel) -> Unit) ={}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoresViewHolder =
        StoresViewHolder(
            StoreItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StoresViewHolder, position: Int) {
        holder.bind(list[position])
    }

   inner class StoresViewHolder(private val binding: StoreItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(storeUIModel: StoreUIModel) = with(binding) {
            binding.root.setOnClickListener {
                onclickstore(storeUIModel)
            }
            Glide.with(itemView.context).load(storeUIModel.imageBackground).into(imagestore)
        }


    }

    fun updateList(updateList: List<StoreUIModel>) {
        this.list.clear()
        this.list.addAll(updateList)
        notifyItemRangeInserted(0, updateList.size)
    }
}