package com.noelvillaman.software.stackoverflowqa.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuestionObjectStackoverflow {
    @SerializedName("items")
    var question_items : List<QuestionsData>? = null
}


class QuestionsData {
    @SerializedName("link")
    @Expose
    var question_link: String? = null

    @SerializedName("title")
    @Expose
    var questionTitle: String? = null
}
