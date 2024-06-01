package com.example.sapcexapplication.domain.use_case.get_capsule

import com.example.sapcexapplication.common.Resource
import com.example.sapcexapplication.data.remote.dto.capsule.toCapsule
import com.example.sapcexapplication.domain.model.Capsule
import com.example.sapcexapplication.domain.repository.CapsuleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCapsuleUseCase @Inject constructor(
    private val repository: CapsuleRepository
) {
    operator fun invoke(capsuleId: String): Flow<Resource<List<Capsule>>> = flow {
        try {
            emit(Resource.Loading<List<Capsule>>())
            val capsules = repository.getCapsules().map { it.toCapsule() }
            emit(Resource.Success<List<Capsule>>(capsules))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Capsule>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Capsule>>("Couldn't reach server. Check your internet connection"))
        }
    }
}