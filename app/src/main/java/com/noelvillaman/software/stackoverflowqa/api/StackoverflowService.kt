package com.noelvillaman.software.stackoverflowqa.api

import com.noelvillaman.software.stackoverflowqa.model.DetailsStackoverflowObject
import com.noelvillaman.software.stackoverflowqa.model.QuestionObjectStackoverflow
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path

interface StackoverflowService {
    @GET("questions")
    fun getAllQuestions() : Call<QuestionObjectStackoverflow>

    @GET("2.3/questions?order=desc&sort=activity&site=stackoverflow&filter=!--s3Tqt4j.JQ")
    fun getStringArrayQuestions() : Call<String>

}