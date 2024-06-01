package com.example.sapcexapplication.data.remote.dto.capsule


import com.example.sapcexapplication.domain.model.Capsule
import com.google.gson.annotations.SerializedName

data class CapsuleDtoModel(
    @SerializedName("capsule_id")
    val capsuleId: String? = "",
    @SerializedName("capsule_serial")
    val capsuleSerial: String? = "",
    @SerializedName("details")
    val details: String? = "",
    @SerializedName("landings")
    val landings: Int? = 0,
    @SerializedName("missions")
    val missions: List<MissionModel?>? = listOf(),
    @SerializedName("original_launch")
    val originalLaunch: String? = "",
    @SerializedName("original_launch_unix")
    val originalLaunchUnix: Int? = 0,
    @SerializedName("reuse_count")
    val reuseCount: Int? = 0,
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("type")
    val type: String? = ""
)
//
fun CapsuleDtoModel.toCapsule(): Capsule {
    return Capsule(
        capsuleId = capsuleId,
        capsuleSerial = capsuleSerial,
        details = details,
        landings = landings,
        missions = missions,
        originalLaunch = originalLaunch,
        originalLaunchUnix = originalLaunchUnix,
        reuseCount = reuseCount,
        status = status,
        type = type
    )
}