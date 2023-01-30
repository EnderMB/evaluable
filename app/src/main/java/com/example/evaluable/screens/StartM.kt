package com.example.evaluable.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.evaluable.bd.ViewModel
import com.example.evaluable.comm.ButtonX

@Composable
fun StartM(navController: NavHostController, ViewModel: ViewModel){
    Column(modifier = Modifier
        .fillMaxSize()
    ){

    }
    Card(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .border(
                BorderStroke(5.dp, Color(0xFF74079C)),
                RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
            )
    ){

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {

        ButtonX(navController, Router = "NewG", Text = "New")

        Spacer(modifier = Modifier.size(15.dp))

        ButtonX(navController, Router = "ModG", Text = "Modify")

        Spacer(modifier = Modifier.size(15.dp))

        ButtonX(navController, Router = "DelG", Text = "Delete")

        Spacer(modifier = Modifier.size(15.dp))

        ButtonX(navController, Router = "FindG", Text = "Finder")

        Spacer(modifier = Modifier.size(15.dp))

        ButtonX(navController, Router = "ShowG", Text = "Show them")

    }

}