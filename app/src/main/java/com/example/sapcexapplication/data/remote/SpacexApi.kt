package com.example.sapcexapplication.data.remote

import com.example.sapcexapplication.data.remote.dto.capsule.CapsuleDetailDto
import com.example.sapcexapplication.data.remote.dto.capsule.CapsuleDtoModel
import retrofit2.http.GET
import retrofit2.http.Path

//interface SpacexApi {
////https://api.spacexdata.com/v3
//    // https://api.spacexdata.com/v3/capsules
//    //https://api.spacexdata.com/v3/history
//    //https://api.spacexdata.com/v3/launches
//    //https://api.spacexdata.com/v3/missions
//    //https://api.spacexdata.com/v3/rockets
//    //https://api.spacexdata.com/v3/ships
//    @GET("/v3/capsules/")
//    suspend fun getCapsules(): List<capsuleDtoModel>
//
//    @GET("/v3/capsules/{capsuleId}/")
//    suspend fun getCapsuleById(@Path("capsuleId") capsuleId: String.Companion = String)
//}

interface SpacexApi {
    // Base URL: https://api.spacexdata.com/
    //https://api.spacexdata.com/v3/capsules/past

    // Get a list of capsule
    // https://api.spacexdata.com/v3/capsules
    @GET("/v3/capsules/")
    suspend fun getCapsules(): List<CapsuleDtoModel>

    // Get details of a specific capsule by ID
    @GET("/v3/capsules/past")
    fun getCapsuleById(@Path("capsule_id") capsuleId: String): CapsuleDetailDto


}
