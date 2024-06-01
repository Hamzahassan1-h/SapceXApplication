package com.example.sapcexapplication.presentation

sealed class Screen (val route: String){
    data object CapsuleListScreen: Screen("capsule_list")
    data object CapsuleDetailScreen: Screen("capsule_detail_screen")
}