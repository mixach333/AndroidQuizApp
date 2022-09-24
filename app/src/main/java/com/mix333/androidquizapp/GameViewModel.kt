package com.mix333.androidquizapp

import androidx.lifecycle.ViewModel
import com.mix333.androidquizapp.repository.ReceiverQuestionsListRepository

class GameViewModel : ViewModel() {
    private val receiverQuestionsListRepository = ReceiverQuestionsListRepository()
    private val questionsList = receiverQuestionsListRepository.receiveQuestions()
}