package com.example.evaluable

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evaluable.comm.ButtonText
import com.example.evaluable.comm.ElementsTxt
import com.example.evaluable.comm.MessageTxt
import com.example.evaluable.bd.Regalos
import com.example.evaluable.bd.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

val db = FirebaseFirestore.getInstance()
val nombre_coleccion = "regalos"

@Composable
fun SaveDat(id: ViewModel, nom: String, obtenido: String, precio: String) {
    var id = id
    var nom = nom
    var obtenido = obtenido
    var precio = precio

    val dato = hashMapOf(
        "id" to id,
        "nom" to nom,
        "obtenido" to obtenido,
        "precio" to precio
    )

    var mensaje_confirmacion by rememberSaveable { mutableStateOf("") }

    Button(
        modifier = Modifier
            .size(200.dp, 60.dp)
            .background(
                Color.Gray,
                CutCornerShape(8.dp)
            ),
        onClick = {
            if (id.isNotEmpty() && nom.isNotEmpty() && obtenido.isNotEmpty() && precio.isNotEmpty()) {
                db.collection(nombre_coleccion)
                    .document(id)
                    .set(dato)
                    .addOnSuccessListener {
                        mensaje_confirmacion = "Data save correctly"
                        id = ""
                        nom = ""
                        obtenido = ""
                        precio = ""
                    }
                    .addOnFailureListener {
                        mensaje_confirmacion = "Something go wrong"
                        id = ""
                        nom = ""
                        obtenido = ""
                        precio = ""
                    }
            } else {
                mensaje_confirmacion = "Fill it"
            }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black
        )
    )
    {
        ButtonText(texto = "Save")
    }
    Spacer(modifier = Modifier.size(15.dp))
    MessageTxt(texto = mensaje_confirmacion)
}

@Composable
fun Del(id: String) {

    var mensaje_borrado by remember { mutableStateOf("") }
    var id = id

    Button(
        modifier = Modifier
            .size(220.dp, 50.dp),

        onClick = {
            if (id.isNotBlank()) {
                db.collection(nombre_coleccion)
                    .document(id)
                    .delete()
                    .addOnSuccessListener {
                        mensaje_borrado = "Delete correctly"
                        id = ""
                    }
                    .addOnFailureListener {
                        mensaje_borrado = "Can't delete it"
                        id = ""
                    }
            } else {
                mensaje_borrado = "It's empty"
            }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black
        )
    )
    {
        ButtonText(texto = "Delete")
    }
    Spacer(modifier = Modifier.size(15.dp))
    MessageTxt(texto = mensaje_borrado)
}

@Composable
fun Mod(id: String, nom: String, obtenido: String, precio: String) {
    var id = id
    var nom = nom
    var obtenido = obtenido
    var precio = precio

    val dato = hashMapOf(
        id to id,
        nom to nom,
        obtenido to obtenido,
        precio to precio
    )
    var mensaje_confirmacion by remember { mutableStateOf("") }

    Button(
        modifier = Modifier
            .size(220.dp, 50.dp),

        onClick = {
            if (id.isNotBlank()) {
                db.collection(nombre_coleccion)
                    .document(id)
                    .delete()
                    .addOnSuccessListener {
                        mensaje_confirmacion = "Data save correctly"
                        id = ""
                        nom = ""
                        obtenido = ""
                        precio = ""
                    }
                    .addOnFailureListener {
                        mensaje_confirmacion = "Something go wrong"
                        id = ""
                        nom = ""
                        obtenido = ""
                        precio = ""
                    }
            } else {
                mensaje_confirmacion = "Can't modify, it's empty"
            }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black
        )
    )
    {
        ButtonText(texto = "Modify")
    }
    Spacer(modifier = Modifier.size(15.dp))
    MessageTxt(texto = mensaje_confirmacion)
}

@Composable
fun Search(find_code: String) {
    var data by remember { mutableStateOf("") }
    var nom = remember { mutableStateOf("") }
    var obtenido = remember { mutableStateOf("") }
    var precio = remember { mutableStateOf("") }

    var find_code = find_code
    val field_search = "id"

    Button(
        modifier = Modifier
            .size(220.dp, 50.dp),

        onClick = {
            data = ""
            nom.value = ""
            obtenido.value = ""
            precio.value = ""

            db.collection(nombre_coleccion)
                .whereEqualTo(field_search, find_code)
                .get()
                //si no da error se recorren los datos de la coleccion y los almacenamos
                .addOnSuccessListener { res ->
                    for (find in res) {
                        //HashMap
                        data += "${find.id}:${find.data}\n"
                        nom.value += "Name: ${find["nom"].toString()}"
                        obtenido.value += "Obtained: ${find["obtenido"].toString()}"
                        precio.value += "Price: ${find["precio"].toString()}"
                    }
                    if (data.isEmpty()) {
                        data = "Isn't exist"
                    }
                }
                //si da error
                .addOnFailureListener { res ->
                    data = "Connection with FireStore can't complet"
                }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black
        )
    )
    {

        ButtonText(texto = "Cargar Datos")
    }

    Spacer(modifier = Modifier.size(10.dp))
    Column(
        //shape = RoundedCornerShape(20.dp),
        // backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Color(0xFF74079C),
                RoundedCornerShape(20.dp)
            )
            .border(
                BorderStroke(5.dp, Color(0xFF1B0303)),
                RoundedCornerShape(20.dp)
            ),
    ) {
        // PINTAMOS EL RESULTADO DE LA CONSULTA A LA BASE DE DATOS
        //Text (text = datos)
        ElementsTxt(texto = nom.value)
        ElementsTxt(texto = obtenido.value)
        ElementsTxt(texto = precio.value)
    }
}

@Composable
fun Show() {
    var datos by remember { mutableStateOf("") }

    var regalo = rememberSaveable { mutableListOf<Regalos>() }

    datos = ""

    db.collection(nombre_coleccion)
        .get()
        .addOnSuccessListener { res ->
            regalo.clear()
            for (finded in res) {
                Log.d("Test", finded.id)

                val aux = Regalos(
                    finded.getString("id") as String,
                    finded.getString("nom") as String,
                    finded.getString("obtenido") as String,
                    finded.getString("precio") as String
                )
                regalo.add(aux)
            }

            if (datos.isEmpty()) {
                datos = "Isn't exist"
            }
        }.addOnFailureListener { res ->
            datos = "Firestore connection hasn't complete"
        }

    Text(
        text = datos,
        color = Color(0xFFFFFFFF),
        fontSize = 20.sp,
        textAlign = TextAlign.Center,

        )
    regalo.forEachIndexed { index, regalo ->

        ItemGift(regalo = regalo)
    }
}

@Composable
fun ItemGift(regalo: Regalos) {
    Spacer(modifier = Modifier.size(16.dp))

    Card(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Brush.horizontalGradient(listOf(Color(0xFF9C64B1), Color(0xFF2D173A))),
                RoundedCornerShape(topStart = 16.dp)
            )
            .border(
                BorderStroke(5.dp, Color(0xFF74079C)),
                RoundedCornerShape(topStart = 20.dp)
            )
    ) {
        Column() {

            regalo.id?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color(0xFFFFFDFD),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }

            regalo.nom?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color(0xFFFFFDFD),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }

            regalo.obtenido?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color(0xFFFFFDFD),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }

            regalo.precio?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color(0xFFFFFDFD),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

