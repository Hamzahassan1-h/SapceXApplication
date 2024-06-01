package com.example.sapcexapplication.domain.use_case.get_capsule

import com.example.sapcexapplication.common.Resource
import com.example.sapcexapplication.data.remote.dto.capsule.toCapsule
import com.example.sapcexapplication.data.remote.dto.capsule.toCapsuleDetail
import com.example.sapcexapplication.domain.model.Capsule
import com.example.sapcexapplication.domain.model.CapsuleDetail
import com.example.sapcexapplication.domain.repository.CapsuleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCapsuleUseCase @Inject constructor(
    private val repository: CapsuleRepository
){
    operator fun invoke(capsuleId : String): Flow<Resource<List<CapsuleDetail>>> = flow {
        try {
            emit(Resource.Loading())
            val capsule1 = repository.getCapsuleById(capsuleId).map { it.toCapsuleDetail() }
            emit(Resource.Success(capsule1))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}