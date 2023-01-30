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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.evaluable.bd.ViewModel
import com.example.evaluable.comm.Texty
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun Updates(navHostController: NavHostController, ViewModel: ViewModel) {
    ViewModel.cleanFields()

    //ModG(ViewModel)
}

@Composable
fun ModG(navHostController: NavHostController, ViewModel: ViewModel) {

    val db = FirebaseFirestore.getInstance()
    var nombre_coleccion = "regalos"

    val id:String by ViewModel.id.observeAsState(initial ="")
    val nom:String by ViewModel.nom.observeAsState(initial ="")
    val obtenido:String by ViewModel.obtenido.observeAsState(initial ="")
    val precio:String by ViewModel.precio.observeAsState(initial ="")
    val context = LocalContext.current

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

        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFA8A8A8),
                            Color(0xFF807C7C)
                        )
                    ),
                )
                .fillMaxWidth()
                .clickable {
                    db
                        .collection(nombre_coleccion)
                        .document(nom)
                        .set(dato)
                        .addOnSuccessListener {
                            Toast
                                .makeText(context, "Data updated", Toast.LENGTH_LONG)
                                .show()
                            ViewModel.cleanFields()
                        }
                        .addOnFailureListener {
                            Toast
                                .makeText(context, "Can't update", Toast.LENGTH_LONG)
                                .show()
                        }
                }
        ) {
            Text(
                text = "Modify Gift",
                fontSize = 26.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.size(300.dp, 40.dp)
            )
        }

        Spacer(modifier = Modifier.size(5.dp))

       /* Mod(
            id = id.value,
            nom = nom.value,
            obtenido = obtenido.value,
            precio = precio.value
        )*/
    }
}