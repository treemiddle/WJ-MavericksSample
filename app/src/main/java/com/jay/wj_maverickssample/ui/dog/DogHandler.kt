package com.jay.wj_maverickssample.ui.dog

import com.jay.wj_maverickssample.data.Dog

interface DogHandler {
    fun onDogClicked(dog: Dog)
    fun adoptLoveDog()
}