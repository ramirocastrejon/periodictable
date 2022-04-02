package com.ramiroc.periodictable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramiroc.periodictable.other.ElementAdapter
import com.ramiroc.periodictable.ui.ElementViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: ElementAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initRecyclerView()

    }

    private fun initRecyclerView(){
        rvElement.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = ElementAdapter()
        rvElement.adapter = recyclerAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ElementViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer { if(it !=null){
            recyclerAdapter.setElements(it)
            recyclerAdapter.notifyDataSetChanged()
        }else {
            Toast.makeText(this, "Error in getting elements", Toast.LENGTH_LONG)
        }
        })
        viewModel.makeAPICall()
    }
}