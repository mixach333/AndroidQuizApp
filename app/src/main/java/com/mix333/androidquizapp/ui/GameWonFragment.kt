package com.mix333.androidquizapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        Log.d("m333", "GameWonFragment view created")
        val result : Int = GameWonFragmentArgs.fromBundle(requireArguments()).resultScore
        Log.d("m333", "received the arg: $result")
        binding.congratsText.text = result.toString()
        Log.d("m333", "result shown")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}