package com.playground.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.playground.R
import com.playground.adapter.AdapterCurrency

class FragmentPickCurrency : Fragment(R.layout.fragment_pick_currency) {

    private lateinit var mRecyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mRecyclerView = view.findViewById(R.id.recyclerView)
        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AdapterCurrency()
        }
    }
}