package com.jay.wj_maverickssample.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_maverickssample.R
import com.jay.wj_maverickssample.databinding.ItemDogBinding
import com.jay.wj_maverickssample.ui.base.LayoutViewHolder

class DogViewHolder(parent: ViewGroup) : LayoutViewHolder(parent, R.layout.item_dog) {
    val binding = ItemDogBinding.bind(itemView)
}