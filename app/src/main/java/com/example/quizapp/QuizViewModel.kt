package com.example.quizapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quizapp.model.QuizItem

class QuizViewModel:ViewModel() {

    var quizList:MutableList<QuizItem> = mutableListOf(
        QuizItem(
            1,
            "What is the capital of Saudi Arabia?",
            listOf<String>("Riyadh","Jeddah","Makkah"),
            "Riyadh"
        ),
        QuizItem(
            2,
            "What is color Black?",
            listOf("Orange", "Blue", "Black"),
            "Black"
        ),
        QuizItem(
            3,
            "What is your favorite color?",
            listOf("Purple","Red","Green"),
            "Green"
        )
    )
    val score = mutableStateOf("")

    fun checkAnswer(quizItem: QuizItem,answer: String){
        quizList = quizList.map{
            if(it.Id==quizItem.Id && answer==it.correctChoice){
                it.copy(isAnswerCorrect = true)
            }
            else if(it.Id==quizItem.Id){
                it.copy(isAnswerCorrect = false)
            }
            else{
                it
            }
        }.toMutableList()
    }
    fun onSubmit(){
        val numOfCorrectAnswers=quizList.filter{ it.isAnswerCorrect}.size
        score.value = "You got ${numOfCorrectAnswers} out of ${quizList.size}"
    }
}