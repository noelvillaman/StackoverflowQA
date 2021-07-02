package com.noelvillaman.software.stackoverflowqa

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.noelvillaman.software.stackoverflowqa.model.QuestionObjectStackoverflow
import com.noelvillaman.software.stackoverflowqa.model.QuestionsData

class StackoverflowListAdapter(val mContext: Context, private val questionList: List<QuestionsData>) : RecyclerView.Adapter<StackoverflowListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.stackoverflow_list_objects,
            parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = questionList.size


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.questionTitle.background = ContextCompat.getDrawable(mContext, reflexionAtWork(questionList.get(position).getquestionImage()))
        holder.questionTitle.text = questionList[position].questionTitle
        holder.questionBody.text = questionList[position].question_link
        holder.itemView.setOnClickListener() {
        }
    }

    fun mostrarquestion(presidentId: Int) {
//        //val intent = Intent(mContext, DetailsActivity::class.java)
//
//        val message = "${presidentId}"
//        val extras = Bundle()
//        intent.putExtras(extras)
//        mContext.startActivity(intent)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTitle: TextView = itemView.findViewById(R.id.question_title)
        val questionBody: TextView = itemView.findViewById(R.id.question_body)
    }
}
