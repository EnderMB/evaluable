package com.example.evaluable.bd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel:ViewModel() {

    private val _id = MutableLiveData<String>()
    val id : LiveData<String> = _id

    private val _nom = MutableLiveData<String>()
    val nom : LiveData<String> = _nom

    private val _obtenido = MutableLiveData<String>()
    val obtenido : LiveData<String> = _obtenido

    private val _precio = MutableLiveData<String>()
    val precio : LiveData<String> = _precio

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable : LiveData<Boolean> = _isButtonEnable

    fun onCompletedFields(id:String, nom:String, obtenido:String, precio:String){
        _id.value = id
        _nom.value = nom
        _obtenido.value = obtenido
        _precio.value = precio
        _isButtonEnable.value = enableButton(id, nom, obtenido, precio)
    }

    fun enableButton(id: String, nom: String, obtenido: String, precio: String)=
        id.length>0 && nom.length> 0 && obtenido.length>0 && precio.length>0

    fun cleanFields(){
        _id.value =""
        _nom.value = ""
        _obtenido.value =""
        _precio.value = ""
    }

    fun onCompleteID(id:String){
        _id.value = id
    }

}