package com.example.sapcexapplication.presentation.space_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sapcexapplication.common.Constants
import com.example.sapcexapplication.common.Resource
import com.example.sapcexapplication.domain.use_case.get_capsule.GetCapsuleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CapsuleDetailViewModel @Inject constructor(
    private val getCapsuleUseCase: GetCapsuleUseCase,
    private val savedStateHandle: SavedStateHandle

): ViewModel(){

    private val _state = mutableStateOf(CapsuleDetailState())
    val state : State<CapsuleDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CAPSULE_ID)?.let { capsuleId ->
            getCapsule(capsuleId)
        }
    }

    private fun getCapsule(capsuleId: String){
        getCapsuleUseCase(capsuleId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CapsuleDetailState(capsules = result.data)
                }
                is Resource.Error -> {
                    _state.value = CapsuleDetailState(
                        error = result.message ?:
                    "An unexpected error occurred ")
                }
                is Resource.Loading -> {
                    _state.value = CapsuleDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}