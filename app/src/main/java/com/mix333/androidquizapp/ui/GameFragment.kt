package com.mix333.androidquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mix333.androidquizapp.GameViewModel
import com.mix333.androidquizapp.databinding.FragmentGameBinding

class GameFragment : Fragment(){
    private var _binding : FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val viewModel : GameViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.questionText.text = viewModel.question.text
        binding.radioButtonAnswer1.text = viewModel.shuffledAnswers[0]
        binding.radioButtonAnswer2.text = viewModel.shuffledAnswers[1]
        binding.radioButtonAnswer3.text = viewModel.shuffledAnswers[2]
        binding.radioButtonAnswer4.text = viewModel.shuffledAnswers[3]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}