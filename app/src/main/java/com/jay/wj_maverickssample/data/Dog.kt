package com.jay.wj_maverickssample.data

import com.jay.wj_maverickssample.ui.base.Identiable

data class Dog(
    val id: Long,
    val name: String,
    val breeds: String,
    val imageUrl: String,
    val description: String
) : Identiable {
    override val stableId = id
}