package com.noelvillaman.software.stackoverflowqa.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuestionObjectStackoverflow {
    @SerializedName("link")
    @Expose
    var question_link: String? = null

    @SerializedName("title")
    @Expose
    var questionTitle: String? = null

    @SerializedName("body")
    @Expose
    var questionBody: String? = null
}
