package com.example.evaluable.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.evaluable.Mod
import com.example.evaluable.SaveDat
import com.example.evaluable.comm.TextyF
import com.google.firebase.firestore.FirebaseFirestore

@Composable

fun NewG(navController: NavHostController) {
    val db = FirebaseFirestore.getInstance()

    var nombre_coleccion = "regalos"
    var id by remember { mutableStateOf("") }
    var nom by remember { mutableStateOf("") }
    var obtenido by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(150.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(10.dp))

        TextyF(param = id, texto = "ID")

        Spacer(modifier = Modifier.size(10.dp))

        TextyF(param = nom, texto = "Name")

        Spacer(modifier = Modifier.size(10.dp))

        TextyF(param = obtenido, texto = "Gifted?")

        Spacer(modifier = Modifier.size(10.dp))

        TextyF(param = precio, texto = "Price")

        Spacer(modifier = Modifier.size(10.dp))

        SaveDat(
            id = id.value,
            nom = nom.value,
            obtenido = obtenido.value,
            precio = precio.value
        )
    }
}