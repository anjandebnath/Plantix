package com.assignment.plantix

import android.app.Application
import android.content.Context

class PlantixApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: PlantixApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
    override fun onCreate() {
        super.onCreate()
    }
}