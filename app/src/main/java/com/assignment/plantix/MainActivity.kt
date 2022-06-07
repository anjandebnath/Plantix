package com.assignment.plantix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.plantix.adapter.UsersListAdapter
import com.assignment.plantix.databinding.ActivityMainBinding
import com.assignment.plantix.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null
    private var _binding: ActivityMainBinding?= null
    private val binding get() = _binding!!

    lateinit var rvAdapter: UsersListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        // pass it to rvLists layoutManager
        binding.rvList.setLayoutManager(layoutManager)

        // initialize the adapter,
        // and pass the required argument
        rvAdapter = UsersListAdapter()

        // attach adapter to the recycler view
        binding.rvList.adapter = rvAdapter

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel?.getResultList()?.observe(this, Observer { itmList ->

             Log.e("Names", itmList.toString())
             rvAdapter.submitList(itmList)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}