package com.example.tayfunbebem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tayfunbebem.databinding.ItemClothesBinding

class ClothesAdapter(private val clothesList: ArrayList<ClothesModel>) :
    RecyclerView.Adapter<ClothesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemClothesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clothesList[position])
    }

    override fun getItemCount(): Int {
        return clothesList.size
    }

    class ViewHolder(private val binding: ItemClothesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ClothesModel) {
            binding.clothesModel = model
        }
    }
}