package com.example.sapcexapplication.domain.model

import com.example.sapcexapplication.data.remote.dto.capsule.MissionModel

data class CapsuleDetail(
    val capsuleId: String? = "",
    //val capsuleSerial: String? = "",
    val details: String? = "",
    //val landings: Int? = 0,
    //val missions: List<MissionModel?>? = listOf(),
    val originalLaunch: String? = "",
    //val originalLaunchUnix: Int? = 0,
    //val reuseCount: Int? = 0,
    val status: String? = "",
    val type: String? = ""
)

