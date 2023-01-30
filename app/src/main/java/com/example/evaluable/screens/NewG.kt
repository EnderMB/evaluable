package com.example.evaluable.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.evaluable.SaveDat
import com.example.evaluable.bd.ViewModel
import com.example.evaluable.comm.TextyF
import com.example.evaluable.navigation.Screens
import com.google.firebase.firestore.FirebaseFirestore

@Composable

fun NewG(navController: NavHostController, ViewModel: ViewModel) {
    ViewModel.cleanFields()
    val db = FirebaseFirestore.getInstance()

    var nombre_coleccion = "regalos"

    val isButtonEnable:Boolean by ViewModel.isButtonEnable.observeAsState (initial = false)

    val id by ViewModel.id.observeAsState(initial ="")
    val nom by ViewModel.nom.observeAsState(initial ="")
    val obtenido by ViewModel.obtenido.observeAsState(initial ="")
    val precio by ViewModel.precio.observeAsState(initial ="")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(150.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(4.dp))

        OutlinedTextField(
            value = id,
            onValueChange = { ViewModel.onCompletedFields(id = it, nom = nom, obtenido = obtenido, precio = precio) },
            label = { Text("Into ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(modifier = Modifier.size(4.dp))

        OutlinedTextField(
            value = nom,
            onValueChange = { ViewModel.onCompletedFields(id = id, nom = it, obtenido = obtenido, precio = precio) },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(modifier = Modifier.size(4.dp))

        OutlinedTextField(
            value = obtenido,
            onValueChange = { ViewModel.onCompletedFields(id = id, nom = nom, obtenido = it, precio = precio) },
            label = { Text("Obtained?") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(modifier = Modifier.size(4.dp))

        OutlinedTextField(
            value = precio,
            onValueChange = { ViewModel.onCompletedFields(id = id, nom = nom, obtenido = obtenido, precio = it) },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(modifier = Modifier.size(4.dp))

        val dato = hashMapOf(
            "id" to id,
            "nom" to nom,
            "obtenido" to obtenido,
            "precio" to precio
        )
        val context = LocalContext.current
        Spacer(modifier = Modifier.padding(16.dp))
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(listOf(Color(0xFFA8A8A8), Color(0xFF807C7C))),
                )
                .fillMaxWidth()
        ) {

            Button(onClick = {

                if (id.isEmpty()) {
                    Toast
                        .makeText(context, "ID", Toast.LENGTH_LONG)
                        .show()
                } else if (nom.isEmpty()) {
                    Toast
                        .makeText(context, "Name", Toast.LENGTH_LONG)
                        .show()
                } else if (obtenido.isEmpty()) {
                    Toast
                        .makeText(context, "Obtained?", Toast.LENGTH_LONG)
                        .show()
                } else if (precio.isEmpty()) {
                    Toast
                        .makeText(context, "Price", Toast.LENGTH_LONG)
                        .show()
                } else {
                    db
                        .collection(nombre_coleccion)
                        .document(nom)
                        .set(dato)
                        .addOnSuccessListener {
                            ViewModel.cleanFields()
                            Toast
                                .makeText(context, "Added correctly", Toast.LENGTH_LONG)
                                .show()
                            navController.navigate(route = Screens.ShowG.rute)
                        }
                        .addOnFailureListener {
                            Toast
                                .makeText(context, "Can't add", Toast.LENGTH_LONG)
                                .show()
                        }
                }
            },
                enabled= isButtonEnable,

                ) {
                Text(
                    text = "Añadir Dragón",
                    fontSize = 26.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.size(300.dp, 40.dp)
                )
            }
        }
    }
}