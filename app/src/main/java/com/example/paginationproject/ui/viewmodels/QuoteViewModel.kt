package com.example.paginationproject.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginationproject.models.ResultModel
import com.example.paginationproject.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val quotesRepository: QuotesRepository) : ViewModel() {
    val quoteList  = quotesRepository.getQuotes().cachedIn(viewModelScope)
}