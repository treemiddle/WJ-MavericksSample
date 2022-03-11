package com.jay.wj_maverickssample.ui.dog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.jay.wj_maverickssample.R
import com.jay.wj_maverickssample.data.Dog
import com.jay.wj_maverickssample.databinding.FragmentDogBinding
import com.jay.wj_maverickssample.ui.DogAdapter
import com.jay.wj_maverickssample.ui.MainViewModel
import com.jay.wj_maverickssample.ui.detail.DogDetailFragment

class DogFragment : Fragment(), MavericksView, DogHandler {

    private lateinit var binding: FragmentDogBinding
    private val activityViewModel: MainViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dog, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.handler = this
        binding.rv.adapter = DogAdapter(this)
    }

    override fun invalidate() = withState(activityViewModel) { state ->
        binding.state = state
    }

    override fun onDogClicked(dog: Dog) {
        findNavController().navigate(R.id.dogDetailFragment, DogDetailFragment.newInstance(dog.id))
    }

    override fun adoptLoveDog() {
        activityViewModel.adopLoveDog()
        findNavController().navigate(R.id.adoptionFragment)
    }

}