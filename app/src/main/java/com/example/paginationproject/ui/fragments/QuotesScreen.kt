package com.example.paginationproject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.paging.filter
import com.example.paginationproject.R
import com.example.paginationproject.databinding.FragmentQuotesScreenBinding
import com.example.paginationproject.ui.adapter.QuotesAdapter
import com.example.paginationproject.ui.viewmodels.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuotesScreen: Fragment() {
    private lateinit var binding: FragmentQuotesScreenBinding
    private lateinit var quotesAdapter: QuotesAdapter

    private val quoteViewModel : QuoteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quotes_screen,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUi()
        setUpObserver()

    }

    private fun setUpObserver() {
        quoteViewModel.quoteList.observe(viewLifecycleOwner){
            quotesAdapter.submitData(lifecycle,it)
        }
    }

    private fun setUpUi() {
        quotesAdapter = QuotesAdapter()
        binding.quotesRecyclerView.adapter = quotesAdapter
        binding.quotesRecyclerView.setHasFixedSize(true)
    }


}