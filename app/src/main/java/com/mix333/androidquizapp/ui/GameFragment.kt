package com.mix333.androidquizapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.mix333.androidquizapp.GameViewModel
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateQuestionsOnScreen()
        viewModel.gameWon.observe(viewLifecycleOwner) { gameWon ->
            if (gameWon) view.findNavController()
                .navigate(R.id.action_gameFragment_to_gameWonFragment)
        }
        viewModel.gameEnded.observe(viewLifecycleOwner) { gameEnded ->
            if (gameEnded) view.findNavController()
                .navigate(R.id.action_gameFragment_to_gameOverFragment)
        }
        binding.submitAnswerButton.setOnClickListener {
            val checkedId = binding.radioGroupAnswers.checkedRadioButtonId
            val answerRadio = view.findViewById<RadioButton>(checkedId)
            viewModel.validateAnswer(answerRadio.text.toString())
            if(checkedId!=-1) {
                when (checkedId) {
                    binding.radioButtonAnswer1.id -> viewModel.validateAnswer(binding.radioButtonAnswer1.text.toString())
                    binding.radioButtonAnswer2.id -> viewModel.validateAnswer(binding.radioButtonAnswer2.text.toString())
                    binding.radioButtonAnswer3.id -> viewModel.validateAnswer(binding.radioButtonAnswer3.text.toString())
                    else -> viewModel.validateAnswer(binding.radioButtonAnswer4.text.toString())
                }
            }
            Log.d("m333", "idChecked is ${binding.radioGroupAnswers.checkedRadioButtonId}")
            Log.d("m333", "id1 is ${binding.radioButtonAnswer1.id}")
            Log.d("m333", "id2 is ${binding.radioButtonAnswer2.id}")
            Log.d("m333", "id3 is ${binding.radioButtonAnswer3.id}")
            Log.d("m333", "id4 is ${binding.radioButtonAnswer4.id}")
            binding.radioGroupAnswers.clearCheck()
            updateQuestionsOnScreen()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateQuestionsOnScreen() {
        binding.apply {
            currentScore.text = viewModel.score.toString()
            questionText.text = viewModel.question.text
            radioButtonAnswer1.text = viewModel.shuffledAnswers[0]
            radioButtonAnswer2.text = viewModel.shuffledAnswers[1]
            radioButtonAnswer3.text = viewModel.shuffledAnswers[2]
            radioButtonAnswer4.text = viewModel.shuffledAnswers[3]
        }
    }
}