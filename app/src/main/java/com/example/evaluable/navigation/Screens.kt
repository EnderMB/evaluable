package com.example.evaluable.navigation

sealed class Screens (val rute: String) {
    object NewG: Screens(rute ="NewG")
    object DellG: Screens(rute ="DelG")
    object FindG: Screens(rute ="FindG")
    object StartM: Screens(rute ="StartM")
    object ShowG: Screens(rute ="ShowG")
    object ModG: Screens(rute ="ModG")
}