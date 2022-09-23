package com.mix333.androidquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private var _binding : FragmentTitleBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        binding.startTheGameButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        binding.aboutButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment_to_aboutFragment)
        }
        binding.readTheRulesButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment_to_rulesFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}