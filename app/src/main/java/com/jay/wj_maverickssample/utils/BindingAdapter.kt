package com.jay.wj_maverickssample.utils

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.Async

@BindingAdapter("visibleIf")
fun visibleIf(view: View, visible: Boolean) {
    view.isVisible = visible
}

@BindingAdapter("asyncList")
fun <T> setListAdapterData(rv: RecyclerView, data: Async<List<T>>?) {
    @Suppress("UNCHECKED_CAST")
    (rv.adapter as ListAdapter<Any, *>).submitList(data?.invoke() ?: emptyList())
}