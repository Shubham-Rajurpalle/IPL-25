package com.cric.ipl25.quizActivity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cric.ipl25.retrofitQuiz.questionsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class quizRepository(private val questionsApi: questionsApi) {

    fun getQuestionsFromApi(): MutableLiveData<questionList> {
        val data = MutableLiveData<questionList>()
        GlobalScope.launch(Dispatchers.IO) {
            val response = questionsApi.getQuestions()
            if (response.isSuccessful) {
                data.postValue(response.body())
            } else {
                Log.e("quizRepository", "Error fetching questions: ${response.errorBody()}")
            }
        }
        return data
    }
}
