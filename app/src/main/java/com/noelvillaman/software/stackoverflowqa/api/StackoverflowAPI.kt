package com.noelvillaman.software.stackoverflowqa.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StackoverflowAPI {
        private val BASE_URL = "http://api.stackexchange.com/docs"

        private var retrofit : Retrofit? = null
        private var stackoverflowService : StackoverflowService? = null

        val instance : StackoverflowService
            get(){
                if (stackoverflowService != null){
                    return stackoverflowService!!
                }
                if (retrofit == null){
                    initializeRetrofit()
                }
                stackoverflowService = retrofit?.create(StackoverflowService::class.java)
                return (stackoverflowService ?: null) as StackoverflowService
            }

        private fun initializeRetrofit(){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
}