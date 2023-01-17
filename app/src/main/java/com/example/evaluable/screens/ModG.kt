package com.example.evaluable.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.evaluable.Mod
import com.example.evaluable.comm.Texty
import com.example.evaluable.comm.TextyF

@Composable
fun ModG(navHostController: NavHostController) {

    val id = remember { mutableStateOf("") }
    val nom = remember { mutableStateOf("") }
    val obtenido = remember { mutableStateOf("") }
    val precio = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(8.dp))

        Texty(texto = "Modify Gift")

        Spacer(modifier = Modifier.size(4.dp))

        TextyF(param = id, texto = "ID")

        Spacer(modifier = Modifier.size(4.dp))

        TextyF(param = nom, texto = "Name")

        Spacer(modifier = Modifier.size(4.dp))

        TextyF(param = obtenido, texto = "Obtained")

        Spacer(modifier = Modifier.size(4.dp))

        TextyF(param = precio, texto = "Price")

        Spacer(modifier = Modifier.size(4.dp))

        Mod(
            id = id.value,
            nom = nom.value,
            obtenido = obtenido.value,
            precio = precio.value
        )
    }
}