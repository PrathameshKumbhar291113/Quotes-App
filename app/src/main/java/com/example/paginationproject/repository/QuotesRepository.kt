package com.example.paginationproject.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paginationproject.network.QuotesApi
import com.example.paginationproject.paging.QuotesPagingSource
import javax.inject.Inject

class QuotesRepository @Inject constructor(val quotesApi: QuotesApi) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotesPagingSource(quotesApi) }
    ).liveData
}