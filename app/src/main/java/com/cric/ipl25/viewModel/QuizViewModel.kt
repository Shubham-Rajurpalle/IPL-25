package com.cric.ipl25.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cric.ipl25.questionList
import com.cric.ipl25.repository.quizRepository
import com.cric.ipl25.retrofit.questionsApi

class QuizViewModel(private val questionsApi: questionsApi) : ViewModel() {

    private val quizRepository: quizRepository = quizRepository(questionsApi)
    var questionLiveData: LiveData<questionList> = quizRepository.getQuestionsFromApi()

    fun getQuestionFromLiveData(): LiveData<questionList> {
        return questionLiveData
    }
}
