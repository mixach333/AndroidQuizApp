package com.mix333.androidquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentGameBinding
import com.mix333.androidquizapp.databinding.FragmentTitleBinding

class GameFragment : Fragment(){
    private var _binding : FragmentGameBinding? = null
    private val binding = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}