package com.jay.wj_maverickssample.ui

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.jay.wj_maverickssample.WJApplication
import com.jay.wj_maverickssample.data.DogRepository
import com.jay.wj_maverickssample.ui.state.DogState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class MainViewModel(
    initialState: DogState,
    private val dogRepository: DogRepository
) : MavericksViewModel<DogState>(initialState) {

    init {
        dogRepository.getDogs().execute { copy(dogs = it) }
    }

    companion object : MavericksViewModelFactory<MainViewModel, DogState> {
        override fun create(viewModelContext: ViewModelContext, state: DogState): MainViewModel {
            val dogRepository = viewModelContext.app<WJApplication>().dogRepository
            return MainViewModel(state, dogRepository)
        }
    }

}