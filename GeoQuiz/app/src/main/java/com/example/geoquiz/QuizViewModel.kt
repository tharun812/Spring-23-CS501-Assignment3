package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val questionBank = listOf(
        Question(R.string.question_australia, true, isCheated = false),
        Question(R.string.question_oceans, true, isCheated = false),
        Question(R.string.question_mideast, false,isCheated = false),
        Question(R.string.question_africa, false, isCheated = false),
        Question(R.string.question_americas, true, isCheated = false),
        Question(R.string.question_asia, true, isCheated = false)
    )
    private var currentIndex : Int
        get() = savedStateHandle.get<Int>(CURRENT_INDEX_KEY)?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    var isCheater: Boolean
        get() = savedStateHandle.get<Boolean>(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun setIsCheatedValue(value: Boolean) {
        questionBank[currentIndex].isCheated = value
    }

    fun getIsCheatedValue(): Boolean {
        return questionBank[currentIndex].isCheated
    }

}