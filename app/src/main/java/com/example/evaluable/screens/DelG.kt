package com.example.evaluable.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.evaluable.bd.ViewModel
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun DelG(navController:NavHostController, ViewModel : ViewModel){

    val db = FirebaseFirestore.getInstance()
    val context = LocalContext.current

    var nombre_coleccion ="regalos"

    val id by ViewModel.id.observeAsState(initial ="")


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
        OutlinedTextField(
            value = id,
            onValueChange ={
                ViewModel.onCompleteID(
                    id = it
                )
            },
            label = { Text("Into ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )
        Spacer(modifier = Modifier.size(10.dp))

        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFA8A8A8),
                            Color(0xFF807C7C)
                        )
                    )
                )
                .fillMaxWidth()
                .clickable {
                    if (id.isNotBlank()) {
                        db
                            .collection(nombre_coleccion)
                            .document(id)
                            .delete()
                            .addOnSuccessListener {
                                ViewModel.cleanFields()
                                Toast
                                    .makeText(context, "Deleted", Toast.LENGTH_LONG)
                                    .show()
                            }
                            .addOnFailureListener {
                                Toast
                                    .makeText(context, "Can't delete", Toast.LENGTH_LONG)
                                    .show()
                            }

                    }
                }
        ) {
            Text(
                text = "Delete Gift",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.size(300.dp, 40.dp)
            )
        }
        //Del(id = id.value)
    }
}