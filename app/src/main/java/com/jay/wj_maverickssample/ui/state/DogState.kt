package com.jay.wj_maverickssample.ui.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.jay.wj_maverickssample.data.Dog

data class DogState(
    val dogs: Async<List<Dog>> = Uninitialized,
    val loveDogId: Long? = null,
    val adoptionRequest: Async<Dog> = Uninitialized
) : MavericksState {
    val loveDog: Dog? = dog(loveDogId)

    fun dog(dogId: Long?): Dog? = dogs()?.firstOrNull { it.id == dogId }
}