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

class GameOverFragment : BaseFragment<FragmentGameOverBinding>(FragmentGameOverBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Game Ended!"
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
}