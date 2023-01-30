package com.example.evaluable.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.evaluable.Search
import com.example.evaluable.bd.ViewModel
import com.example.evaluable.comm.Texty
import com.example.evaluable.comm.TextyF

@Composable
fun FindG(navHostController: NavHostController, ViewModel: ViewModel){
    ViewModel.cleanFields()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Spacer(modifier = Modifier.size(8.dp))
        Texty(
            texto = "Gift search"
        )
        Spacer(modifier = Modifier.size(8.dp))

        var find_code = remember{ mutableStateOf("")}

        TextyF(param = find_code, texto = "Try ID to find")

        Spacer(modifier = Modifier.size(4.dp))

        Search(find_code = find_code.value)
    }
}