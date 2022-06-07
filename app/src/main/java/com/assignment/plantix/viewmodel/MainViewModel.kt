package com.assignment.plantix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.plantix.domain.NamesModel
import com.assignment.plantix.repository.DataRepository

class MainViewModel : ViewModel {

    private var itemMutableList : MutableLiveData<List<NamesModel>>? = null
    private var dataRepository: DataRepository? = null


    constructor()
    {
        if(itemMutableList != null){
            return
        }
        dataRepository = DataRepository.getinstance()
        itemMutableList = dataRepository?.getUserNames()
    }

    fun getResultList() : MutableLiveData<List<NamesModel>>? {

        if(itemMutableList != null)
        {
            itemMutableList
        }
        return  itemMutableList
    }
}