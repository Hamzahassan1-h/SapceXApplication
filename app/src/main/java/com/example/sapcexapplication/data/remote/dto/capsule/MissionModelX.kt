package com.example.sapcexapplication.data.remote.dto.capsule


import com.google.gson.annotations.SerializedName

data class MissionModelX(
    @SerializedName("flight")
    val flight: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
)