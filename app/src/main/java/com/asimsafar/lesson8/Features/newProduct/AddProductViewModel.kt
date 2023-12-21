package com.asimsafar.lesson8.Features.newProduct

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddProductViewModel: ViewModel() {

    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    val newProductCallBack = MutableLiveData<Boolean>()

    val error = MutableLiveData<String>()

    fun onNewProductInsert(){
        if (name.value.isNullOrEmpty() || code.value.isNullOrEmpty() || description.value.isNullOrEmpty()){
            error.postValue("ERROR")
            return
        }

        newProductCallBack.postValue(true)

    }

}