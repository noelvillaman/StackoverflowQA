package com.noelvillaman.software.stackoverflowqa.api

import com.noelvillaman.software.stackoverflowqa.model.DetailsStackoverflowObject
import com.noelvillaman.software.stackoverflowqa.model.QuestionObjectStackoverflow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StackoverflowService {
    @get:GET("/answers")
    val stackoverflowAnswers : Call<List<ObjectStackoverflow>>

    @GET("/questions")
    fun getAllQuestions() : Call<List<QuestionObjectStackoverflow>>

    @GET("answers/{answer_idinteger}")
    fun getDetalles(@Path("answer_idinteger") answer_idinteger : Int) : Call<DetailsStackoverflowObject>
}