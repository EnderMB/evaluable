package com.example.evaluable.bd

import androidx.compose.runtime.*
import com.google.firebase.firestore.FirebaseFirestore
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun SavData(ViewModel: ViewModel){
    val db = FirebaseFirestore.getInstance()

    val nombre_coleccion = "regalos"

    val id:String by ViewModel.id.observeAsState(initial ="")
    val nom:String by ViewModel.nom.observeAsState(initial ="")
    val obtenido:String by ViewModel.obtenido.observeAsState(initial ="")
    val precio:String by ViewModel.obtenido.observeAsState(initial ="")
}