package com.example.sapcexapplication.data.repository

import com.example.sapcexapplication.data.remote.SpacexApi
import com.example.sapcexapplication.data.remote.dto.capsule.CapsuleDetailDto
import com.example.sapcexapplication.data.remote.dto.capsule.CapsuleDtoModel
import com.example.sapcexapplication.domain.repository.CapsuleRepository
import javax.inject.Inject

class CapsuleRepositoryImplementation @Inject constructor(
    private val api: SpacexApi
) : CapsuleRepository{
    override suspend fun getCapsules(): List<CapsuleDtoModel> {
        return api.getCapsules()
    }

    override suspend fun getCapsuleById(capsuleId: String): CapsuleDetailDto {
        return api.getCapsuleById(capsuleId)
    }
}