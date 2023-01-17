package com.example.evaluable.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.evaluable.Del


@Composable
fun DelG(navController:NavHostController){

    var id = remember{ mutableStateOf("")}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 185.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .verticalScroll(rememberScrollState()),

        ) {
        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = "Delete Gift"
        )

        Spacer(modifier = Modifier.size(10.dp))



        Spacer(modifier = Modifier.size(5.dp))

        Del(id = id.value)
    }
}