package com.example.paginationproject.models


import com.google.gson.annotations.SerializedName

data class QuotesListModel(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("lastItemIndex")
    var lastItemIndex: Int?,
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var results: List<ResultModel>,
    @SerializedName("totalCount")
    var totalCount: Int?,
    @SerializedName("totalPages")
    var totalPages: Int?
)
