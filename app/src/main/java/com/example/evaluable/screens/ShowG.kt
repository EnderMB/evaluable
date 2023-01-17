package com.example.evaluable.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.evaluable.Show
import com.example.evaluable.comm.Texty

@Composable
fun ShowG(navHostController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(200.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(8.dp))
    }
    Texty(texto = "Select data from FireStore Cloud")

    Spacer(modifier = Modifier.size(8.dp))

    Show()
}