package com.example.paginationproject.models

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("author")
    var author: String?,
    @SerializedName("authorSlug")
    var authorSlug: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("dateAdded")
    var dateAdded: String?,
    @SerializedName("dateModified")
    var dateModified: String?,
    @SerializedName("_id")
    var id: String?,
    @SerializedName("length")
    var length: Int?,
    @SerializedName("tags")
    var tags: List<String?>?
)