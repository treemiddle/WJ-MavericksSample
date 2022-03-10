package com.jay.wj_maverickssample.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class LayoutViewHolder(
    parent: ViewGroup,
    @LayoutRes layoutResId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        layoutResId,
        parent,
        false
    )
)