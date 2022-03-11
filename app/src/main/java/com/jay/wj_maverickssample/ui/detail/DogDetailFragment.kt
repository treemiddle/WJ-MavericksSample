package com.jay.wj_maverickssample.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.*
import com.jay.wj_maverickssample.R
import com.jay.wj_maverickssample.databinding.FragmentDogDetailBinding
import com.jay.wj_maverickssample.ui.MainViewModel

class DogDetailFragment : Fragment(), MavericksView, DogDetailHandler {

    private lateinit var binding: FragmentDogDetailBinding
    private val activityViewModel: MainViewModel by activityViewModel()
    private val dogId: Long by args()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dog_detail, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.handler = this
    }

    override fun invalidate() = withState(activityViewModel) { state ->
        binding.dog = state.dog(dogId) ?: error(":can't find dog with id $dogId")
    }

    override fun onLoveClicked() {
        activityViewModel.loveDog(dogId)
        findNavController().popBackStack()
    }

    companion object {
        fun newInstance(dogId: Long) = bundleOf(Mavericks.KEY_ARG to dogId)
    }

}