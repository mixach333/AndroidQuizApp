package com.mix333.androidquizapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.mix333.androidquizapp.GameViewModel
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentGameBinding

fun RadioGroup.getCheckedText(view: View) : String{
    var checkedId = this.checkedRadioButtonId
    var result = ""
    if(checkedId!=-1){
        result = (view.findViewById<RadioButton>(checkedId)).text.toString()
    }
    return result
}


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
            if (gameWon) {
                val action = GameFragmentDirections.actionGameFragmentToGameWonFragment(
                    viewModel.score, viewModel.getPercentage())
                view.findNavController().navigate(action)
            }
        }
        viewModel.gameEnded.observe(viewLifecycleOwner) { gameEnded ->
            if (gameEnded) view.findNavController()
                .navigate(R.id.action_gameFragment_to_gameOverFragment)
        }
        binding.submitAnswerButton.setOnClickListener {
            val answerToValidation = binding.radioGroupAnswers.getCheckedText(view)
            if (answerToValidation!="") viewModel.validateAnswer(answerToValidation)
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
            questionNumber.text = getString(
                R.string.question_number_now_and_total,
                viewModel.currentQuestionNumber.toString(),
                viewModel.questionsQuantity.toString())
        }
    }
}