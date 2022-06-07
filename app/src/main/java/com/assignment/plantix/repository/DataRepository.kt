package com.assignment.plantix.repository


import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.assignment.plantix.PlantixApplication
import com.assignment.plantix.domain.NamesModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class DataRepository() {

    companion object{
        private var instance: DataRepository? = null
        val context: Context = PlantixApplication.applicationContext()
        var nameMutableList: MutableLiveData<List<NamesModel>> = MutableLiveData()

        fun getinstance(): DataRepository {
            if (instance == null){
                instance = DataRepository()
            }

            return instance as DataRepository
        }
    }


    fun getUserNames(): MutableLiveData<List<NamesModel>> {

        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("names.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
        }

        val listUsers = object : TypeToken<List<NamesModel>>() {}.type
        nameMutableList.value = Gson().fromJson(jsonString, listUsers)
        return nameMutableList
    }

}