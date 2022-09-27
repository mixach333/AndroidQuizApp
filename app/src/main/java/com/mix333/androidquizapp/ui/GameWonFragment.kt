package com.mix333.androidquizapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentGameWonBinding
import com.mix333.androidquizapp.databinding.FragmentTitleBinding

class GameWonFragment : Fragment() {
    private var _binding : FragmentGameWonBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameWonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result : Int = GameWonFragmentArgs.fromBundle(requireArguments()).resultScore
        val percentage : Int = GameWonFragmentArgs.fromBundle(requireArguments()).percentage
        val percentage1 = "$percentage%"
        binding.congratsTextView.text = getString(R.string.congrats_text, result.toString(), percentage1)
        if(percentage!=100) {
            binding.congratsNotPerfectHolder.visibility = View.VISIBLE
            binding.congratsNotPerfectTextView.text = getString(R.string.congrats_not_perfect)
                    }
        binding.startNewGameButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameWonFragment_to_titleFragment)
        }
        binding.shareResultButton.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT,
                    "Hey! My score is $result! Come and join me on AndroidQuizApp!")
            if(activity?.packageManager?.resolveActivity(shareIntent, 0)!=null){
                startActivity(shareIntent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}