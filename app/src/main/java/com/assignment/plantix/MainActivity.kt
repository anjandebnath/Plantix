package com.assignment.plantix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.assignment.plantix.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel?.getResultList()?.observe(this, Observer { itmList ->

             Log.e("Names", itmList.toString())
        })

    }
}