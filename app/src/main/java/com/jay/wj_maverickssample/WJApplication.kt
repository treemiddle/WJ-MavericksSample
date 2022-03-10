package com.jay.wj_maverickssample

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.jay.wj_maverickssample.data.DogRepository

class WJApplication : Application() {

    lateinit var dogRepository: DogRepository

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)

        dogRepository = DogRepository()
    }
}