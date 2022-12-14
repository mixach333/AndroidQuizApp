package com.mix333.androidquizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mix333.androidquizapp.model.Question
import com.mix333.androidquizapp.repository.ReceiverQuestionsListRepository


class GameViewModel : ViewModel() {
    private val receiverQuestionsListRepository = ReceiverQuestionsListRepository()
    private var questionsList: MutableList<Question> =
        receiverQuestionsListRepository.receiveQuestions().shuffled().toMutableList()
    var question: Question
    var currentQuestionNumber: Int = 1
    var shuffledAnswers: List<String>
    private var _gameWon = MutableLiveData<Boolean>()
    val gameWon get() : LiveData<Boolean> = _gameWon
    private var _gameEnded = MutableLiveData<Boolean>()
    val gameEnded get() : LiveData<Boolean> = _gameEnded
    var questionsQuantity = -1
    var score = 0

    init {
        question = questionsList[0]
        shuffledAnswers = question.answers.shuffled()
        questionsQuantity = receiveQuestionsCount()
    }

    private fun receiveQuestionsCount(): Int {
        var questionsQuantity = (Math.random() * questionsList.size).toInt()
        if (questionsQuantity < 5) {
            questionsQuantity = 5
        }
        return questionsQuantity
    }


    private fun hasNextQuestionOrGameOver() {
        val result = currentQuestionNumber < questionsQuantity
        if (result) {
            currentQuestionNumber++
        } else {
            if (getPercentage() < 80) {
                _gameEnded.value = true
            } else {
                _gameWon.value = true
            }
        }
    }

    private fun updateQuestionTextAndAnswers() {
        hasNextQuestionOrGameOver()
        question = questionsList[currentQuestionNumber - 1]
        shuffledAnswers = question.answers.shuffled()
    }

    fun validateAnswer(answer: String) {
        if (answer == question.answers[0]) score += 10
        updateQuestionTextAndAnswers()
    }

    fun getPercentage(): Int {
        return ((score.toDouble() / questionsQuantity.toDouble()) * 10).toInt()
    }
}