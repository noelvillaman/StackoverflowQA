package com.noelvillaman.software.stackoverflowqa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noelvillaman.software.stackoverflowqa.api.StackoverflowAPI
import com.noelvillaman.software.stackoverflowqa.model.QuestionObjectStackoverflow
import com.noelvillaman.software.stackoverflowqa.model.QuestionsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var recyclerView : RecyclerView? = null
    private var mAdater : StackoverflowListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //questionsNetworking()

        questionsNetworkingString()

    }

    private fun questionsNetworking(){
        val api = StackoverflowAPI.instance
        val call = api.getAllQuestions()


        call.enqueue(object : Callback<QuestionObjectStackoverflow> {
            override fun onResponse(call: Call<QuestionObjectStackoverflow>,
                                    response: Response<QuestionObjectStackoverflow>) {
                if (response != null && response.isSuccessful){
                    response.body()?.question_items?.let { generateQuestionsData(it) }
                    Log.i("RESPONSE", response.body().toString())
                }
            }

            override fun onFailure(call: Call<QuestionObjectStackoverflow>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun questionsNetworkingString(){
        val api = StackoverflowAPI.instance
        val call = api.getStringArrayQuestions()


        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>,
                                    response: Response<String>) {
                if (response != null && response.isSuccessful){
                    response.body()
                    Log.i("RESPONSE", response.body().toString())
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun generateQuestionsData(list: List<QuestionsData>) {
        recyclerView = findViewById(R.id.list_container)
        mAdater = StackoverflowListAdapter(this, list)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        if (layoutManager != null){
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = mAdater
            recyclerView!!.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }
    }
}