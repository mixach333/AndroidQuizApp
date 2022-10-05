package com.mix333.androidquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.mix333.androidquizapp.GameViewModel
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentGameBinding
import com.mix333.androidquizapp.getCheckedText


class GameFragment : BaseFragment<FragmentGameBinding>(FragmentGameBinding::inflate){
    private val viewModel: GameViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateQuestionsOnScreen()
        viewModel.gameWon.observe(viewLifecycleOwner) { gameWon ->
            if (gameWon) {
                val action = GameFragmentDirections.actionGameFragmentToGameWonFragment(
                    viewModel.score, viewModel.getPercentage()
                )
                view.findNavController().navigate(action)
            }
        }
        viewModel.gameEnded.observe(viewLifecycleOwner) { gameEnded ->
            if (gameEnded) view.findNavController()
                .navigate(R.id.action_gameFragment_to_gameOverFragment)
        }
        binding.submitAnswerButton.setOnClickListener {
            val answerToValidation = binding.radioGroupAnswers.getCheckedText(view)
            if (answerToValidation != "") {
                viewModel.validateAnswer(answerToValidation)
                binding.radioGroupAnswers.clearCheck()
                updateQuestionsOnScreen()
            }
        }
        binding.endGameButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
        }
    }

    private fun updateQuestionsOnScreen() {
        binding.apply {
            currentScore.text = getString(R.string.current_score, viewModel.score)
            questionText.text = viewModel.question.text
            radioButtonAnswer1.text = viewModel.shuffledAnswers[0]
            radioButtonAnswer2.text = viewModel.shuffledAnswers[1]
            radioButtonAnswer3.text = viewModel.shuffledAnswers[2]
            radioButtonAnswer4.text = viewModel.shuffledAnswers[3]
            (activity as AppCompatActivity).supportActionBar?.title = getString(
                R.string.question_number_now_and_total,
                viewModel.currentQuestionNumber.toString(),
                viewModel.questionsQuantity.toString()
            )
        }
    }
}