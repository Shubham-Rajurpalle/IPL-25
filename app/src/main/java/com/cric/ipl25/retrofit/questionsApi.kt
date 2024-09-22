package com.cric.ipl25.retrofit

import com.cric.ipl25.questionList
import retrofit2.Response
import retrofit2.http.GET

interface questionsApi {
    @GET("ipl_api.php")
    suspend fun getQuestions():Response<questionList>

    }