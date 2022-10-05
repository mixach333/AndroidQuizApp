package com.mix333.androidquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentAboutBinding

class AboutFragment : BaseFragment<FragmentAboutBinding>(FragmentAboutBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.backToTitleButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_aboutFragment_to_titleFragment)
        }
        return binding.root
    }
}