package com.example.sapcexapplication.domain.use_case.get_capsules

import com.example.sapcexapplication.common.Resource
import com.example.sapcexapplication.data.remote.dto.capsule.toCapsule
import com.example.sapcexapplication.domain.model.Capsule
import com.example.sapcexapplication.domain.repository.CapsuleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCapsulesUseCase @Inject constructor(
    private val repository: CapsuleRepository
){
    operator fun invoke(): Flow<Resource<List<Capsule>>> = flow {
        try {
            emit(Resource.Loading())
            val capsule = repository.getCapsules().map { it.toCapsule() }
            emit(Resource.Success(capsule))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}