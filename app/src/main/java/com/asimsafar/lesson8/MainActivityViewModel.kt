package com.asimsafar.lesson8

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var addProductObserver = MutableLiveData<Boolean>()

    var result = MutableLiveData<String>()

    fun onAddNewProduct(){
        addProductObserver.postValue(true)
    }

    fun newProductAdded(){
        result.postValue("")

    }
}