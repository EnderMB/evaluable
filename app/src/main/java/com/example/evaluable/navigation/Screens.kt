package com.example.evaluable.navigation

sealed class Screens (val rute: String) {
    object NewG: Screens("NewG")
    object DellG: Screens("DelG")
    object FindG: Screens("FindG")
    object StartM: Screens("StartM")
    object ShowG: Screens("ShowG")
    object ModG: Screens("ModG")
}