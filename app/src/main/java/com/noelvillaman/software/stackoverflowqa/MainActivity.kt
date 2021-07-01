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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var recyclerView : RecyclerView? = null
    private var mAdater : StackoverflowListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionsNetworking()

    }

    private fun questionsNetworking(){
        val api = StackoverflowAPI.instance
        val call = api.getAllQuestions()


        call.enqueue(object : Callback<List<QuestionObjectStackoverflow>> {
            override fun onResponse(call: Call<List<QuestionObjectStackoverflow>>, 
                                    response: Response<List<QuestionObjectStackoverflow>>) {
                if (response != null && response.isSuccessful){
                    generateQuestionsData(response.body()!!)
                    Log.i("RESPONSE", response.body().toString())
                }
            }

            override fun onFailure(call: Call<List<QuestionObjectStackoverflow>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun generateQuestionsData(list: List<QuestionObjectStackoverflow>) {
        recyclerView = findViewById(R.id.list_container)
        mAdater = StackoverflowListAdapter(this, list as ArrayList<QuestionObjectStackoverflow>)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        if (layoutManager != null){
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = mAdater
            recyclerView!!.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }
    }
}