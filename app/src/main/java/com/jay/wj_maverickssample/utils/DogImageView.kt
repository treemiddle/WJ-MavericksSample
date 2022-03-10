package com.jay.wj_maverickssample.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

class DogImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    fun setUrl(url: String?) {
        url ?: return

        Glide.with(context)
            .load(url)
            .into(this)
    }

}