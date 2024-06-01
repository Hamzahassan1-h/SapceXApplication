package com.example.sapcexapplication.domain.repository

import com.example.sapcexapplication.data.remote.dto.capsule.CapsuleDetailDto
import com.example.sapcexapplication.data.remote.dto.capsule.CapsuleDtoModel

interface CapsuleRepository {

    suspend fun getCapsules() : List<CapsuleDtoModel>

    suspend fun getCapsuleById(capsuleId: String ) : CapsuleDetailDto

}