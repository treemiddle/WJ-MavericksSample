package com.jay.wj_maverickssample.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jay.wj_maverickssample.data.Dog
import com.jay.wj_maverickssample.ui.dog.DogHandler

class DogAdapter(
    private val listener: DogHandler
) : ListAdapter<Dog, DogViewHolder>(object : DiffUtil.ItemCallback<Dog>() {
    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem.stableId == newItem.stableId
    }

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem == newItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(parent).apply {
            binding.handler = listener
        }
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.binding.dog = getItem(position)
    }

}