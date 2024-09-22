package com.cric.ipl25

import api_scoreInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class retrofitInstance( baseUrl: String) {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val matchApiService = retrofit.create(api_scoreInterface::class.java)

    suspend fun getData(matchId: Any?) =
        matchApiService.getData( matchId)
}
