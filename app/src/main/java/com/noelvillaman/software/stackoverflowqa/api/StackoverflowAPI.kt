package com.noelvillaman.software.stackoverflowqa.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object StackoverflowAPI {
        private val BASE_URL = "https://api.stackexchange.com/docs/"

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
            val gson = GsonBuilder()
                .setLenient()
                .create()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}