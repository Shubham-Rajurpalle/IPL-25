package com.cric.ipl25.retrofitQuiz

import com.cric.ipl25.quizActivity.questionList
import retrofit2.Response
import retrofit2.http.GET

interface questionsApi {
    @GET("ipl_api.php")
    suspend fun getQuestions():Response<questionList>

    }