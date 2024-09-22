package com.cric.ipl25.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cric.ipl25.retrofit.questionsApi

class QuizViewModelFactory(private val questionsApi: questionsApi) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(questionsApi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
