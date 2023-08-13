package com.example.paginationproject.network

import com.example.paginationproject.models.QuotesListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotesList(@Query("page") page : Int) : QuotesListModel
}