package com.jay.wj_maverickssample.ui.adopt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.jay.wj_maverickssample.R
import com.jay.wj_maverickssample.databinding.FragmentAdoptionBinding
import com.jay.wj_maverickssample.ui.MainViewModel

class AdoptionFragment : Fragment(), MavericksView {

    private lateinit var binding: FragmentAdoptionBinding
    private val activityViewModel: MainViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_adoption, container, false)

        return binding.root
    }

    override fun invalidate() = withState(activityViewModel) { state ->
        binding.dog = state.adoptionRequest()
    }

}