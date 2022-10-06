package com.mix333.androidquizapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.findNavController
import com.mix333.androidquizapp.R
import com.mix333.androidquizapp.databinding.FragmentGameWonBinding

class GameWonFragment : BaseFragment<FragmentGameWonBinding>(FragmentGameWonBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Game Won!"
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result : Int = GameWonFragmentArgs.fromBundle(requireArguments()).resultScore
        val percentage : Int = GameWonFragmentArgs.fromBundle(requireArguments()).percentage
        val percentageToDisplay = "$percentage%"
        binding.apply{
            congratsTextView.text = getString(R.string.congrats_text, result.toString(), percentageToDisplay)
            if(percentage!=100) {
                congratsNotPerfectHolder.visibility = View.VISIBLE
                congratsNotPerfectTextView.text = getString(R.string.congrats_not_perfect)
            }
            startNewGameButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_gameWonFragment_to_titleFragment)
            }
            shareResultButton.setOnClickListener{
                val shareIntent = Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(Intent.EXTRA_TEXT,
                        "Hey! My score is $result! Come and join me on AndroidQuizApp!")
                if(activity?.packageManager?.resolveActivity(shareIntent, 0)!=null){
                    startActivity(shareIntent)
                }
            }}

    }
}