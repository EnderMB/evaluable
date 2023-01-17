package com.example.evaluable.comm

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ButtonText(texto: String) {
    Text(text = texto, color = Color.Black, fontSize = 15.sp)
}

@Composable
fun MessageTxt(texto: String) {
    Card(
        backgroundColor = Color.Transparent,
        shape = CutCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFF74079C))
    ) {
        Text(
            text = texto,
            color = Color(0x81FFFFFF)
        )
    }
}

@Composable
fun ElementsTxt(texto: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(
                BorderStroke(3.dp, Color.Black),
                RoundedCornerShape(15.dp)
            ),
    ) {
        Text(
            text = texto,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonX(navController: NavHostController, Router: String, Text: String) {
    Button(
        modifier = Modifier
            .size(220.dp, 80.dp),
        onClick = {
            navController.navigate(Router)

        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black
        ),
        border = BorderStroke(4.dp, Color.White)
    )

    {
        Text(text = Text, fontSize = 25.sp)
    }
}

@Composable
fun Texty(texto:String){
    Card(
        shape = CutCornerShape( 20.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .height(50.dp)
            .fillMaxSize()
            .background(color=Color(0xFF74079C),CutCornerShape( 20.dp))
            .border(
                BorderStroke(5.dp, Color.Black),
                CutCornerShape( 10.dp)
            ),

        ) {
        Text(
            text = texto,
            modifier = Modifier.padding(top = 10.dp),
            color = Color(0xFF44065A),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TextyF(param: MutableState<String>, texto: String){
    OutlinedTextField(
        shape = RoundedCornerShape(topStart = 30.dp),
        value = param.value,
        onValueChange = { param.value = it },
        label = { Text(texto) },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(listOf(Color(0xFF74079C), Color(0xFF1F0031))),
                RoundedCornerShape(topStart = 30.dp)
            ),

        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFF1B0303),
            focusedBorderColor = Color(0xFF74079C),
            focusedLabelColor = Color(0xFFFCACFF),
            unfocusedLabelColor = Color(0xFFFEFFFE),
            cursorColor = Color(0xFF6904F7)
        ),
        textStyle = TextStyle.Default.copy(fontSize = 28.sp),
    )
}

