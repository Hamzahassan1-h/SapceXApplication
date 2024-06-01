package com.example.sapcexapplication.data.remote.dto.capsule


import com.example.sapcexapplication.domain.model.Capsule
import com.example.sapcexapplication.domain.model.CapsuleDetail
import com.google.gson.annotations.SerializedName

data class CapsuleDetailDtoItemModel(
    @SerializedName("capsule_id")
    val capsuleId: String? = "",
    @SerializedName("capsule_serial")
    val capsuleSerial: String? = "",
    @SerializedName("details")
    val details: String? = "",
    @SerializedName("landings")
    val landings: Int? = 0,
    @SerializedName("missions")
    val missions: List<MissionModelX>? = listOf(),
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
fun CapsuleDetailDtoItemModel.toCapsuleDetail(): CapsuleDetail {
    return CapsuleDetail(
        capsuleId = capsuleId,
        //capsuleSerial = capsuleSerial,
        details = details,
        //landings = landings,
        //missions = missions,
        originalLaunch = originalLaunch,
        //originalLaunchUnix = originalLaunchUnix,
        //reuseCount = reuseCount,
        status = status,
        type = type
    )
}