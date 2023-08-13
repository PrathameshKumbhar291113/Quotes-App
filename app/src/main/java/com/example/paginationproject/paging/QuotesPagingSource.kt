package com.example.paginationproject.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationproject.models.ResultModel
import com.example.paginationproject.network.QuotesApi
import java.lang.Exception

class QuotesPagingSource(val quotesApi: QuotesApi) : PagingSource<Int, ResultModel>(){
    override fun getRefreshKey(state: PagingState<Int, ResultModel>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultModel> {
        return try {
            val pagePosition = params.key?: 1
            val response = quotesApi.getQuotesList(pagePosition)
            LoadResult.Page(
                data = response.results,
                prevKey = if (pagePosition !=  1) pagePosition-1 else null,
                nextKey = if (pagePosition != response.totalPages) pagePosition+1 else null
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}