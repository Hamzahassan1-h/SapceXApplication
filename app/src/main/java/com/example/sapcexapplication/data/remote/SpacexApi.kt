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

    // Get a list of capsules
    @GET("c/v3/capsules/")
    suspend fun getCapsules(): List<CapsuleDtoModel>

    // Get details of a specific capsule by ID
    @GET("/v3/capsules/past")
    fun getCapsuleById(@Path("capsule_id") capsuleId: String): CapsuleDetailDto

    // Get a list of historical events
    //@GET("history")
    //fun getHistory(): List<HistoryEvent>

    // Get a list of launches
    //@GET("launches")
    //suspend fun getLaunches(): List<Launch>

    // Get details of a specific launch by ID
    //@GET("launches/{launch_id}")
    //suspend fun getLaunchDetails(@Path("launch_id") launchId: String): Launch

    // Get a list of missions
    //@GET("missions")
    //suspend fun getMissions(): List<Mission>

    // Get details of a specific mission by ID
    //@GET("missions/{mission_id}")
    //suspend fun getMissionDetails(@Path("mission_id") missionId: String): Mission

    // Get a list of rockets
    //@GET("rockets")
    // suspend fun getRockets(): List<Rocket>

    // Get details of a specific rocket by ID
    //@GET("rockets/{rocket_id}")
    //suspend fun getRocketDetails(@Path("rocket_id") rocketId: String): Rocket

    // Get a list of ships
    //@GET("ships")
    //suspend fun getShips(): List<Ship>

    // Get details of a specific ship by ID
    //@GET("ships/{ship_id}")
    //suspend fun getShipDetails(@Path("ship_id") shipId: String): Ship
}
