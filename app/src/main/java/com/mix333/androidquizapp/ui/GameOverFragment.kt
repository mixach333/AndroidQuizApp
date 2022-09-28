package com.mix333.androidquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentGameOverBinding
import com.mix333.androidquizapp.databinding.FragmentTitleBinding

class GameOverFragment : Fragment() {
    private var _binding : FragmentGameOverBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameOverBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Game Ended!"
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startNewGameAfterGameEndedButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
        }
        binding.getToTitleAfterGameEndedButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameOverFragment_to_titleFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}