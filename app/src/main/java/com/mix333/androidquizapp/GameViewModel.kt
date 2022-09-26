package com.mix333.androidquizapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mix333.androidquizapp.model.Question
import com.mix333.androidquizapp.repository.ReceiverQuestionsListRepository
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val receiverQuestionsListRepository = ReceiverQuestionsListRepository()
    private lateinit var questionsList: MutableList<Question>
    private var currentQuestionNumber : Int = 1
    lateinit var question : Question
    lateinit var shuffledAnswers : List<String>
    private var questionsQuantity = -1
    private var _gameWon = MutableLiveData<Boolean>()
    val gameWon get() : LiveData<Boolean> = _gameWon
    private var _gameEnded = MutableLiveData<Boolean>()
    val gameEnded get() : LiveData<Boolean> = _gameEnded
    var score = 0

    init {
        viewModelScope.launch {
            questionsList = receiverQuestionsListRepository.receiveQuestions().shuffled().toMutableList()
            question = questionsList[0]
            shuffledAnswers = question.answers.shuffled()
            questionsQuantity = receiveQuestionsCount()
        }
    }
    private fun receiveQuestionsCount() : Int {
        var questionsQuantity = (Math.random()*questionsList.size).toInt()
        if(questionsQuantity<5) {questionsQuantity = 5}
        return questionsQuantity
    }


    private fun hasNextQuestionOrGameOver(){
        val result = currentQuestionNumber<questionsQuantity
        if(result) {
            currentQuestionNumber++
        }else {
            _gameWon.value = true
        }
    }

    private fun updateQuestionTextAndAnswers(){
        hasNextQuestionOrGameOver()
        question = questionsList[currentQuestionNumber-1]
        shuffledAnswers = question.answers.shuffled()
    }

    fun validateAnswer(answer: String){
        if(answer.equals(question.answers[0])){
            score++
            updateQuestionTextAndAnswers()
        } else {
            updateQuestionTextAndAnswers()
        }
    }


}