package com.example.sapcexapplication.presentation.space_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sapcexapplication.common.Resource
import com.example.sapcexapplication.domain.use_case.get_capsules.GetCapsulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CapsuleListViewModel @Inject constructor(
    private val getCapsulesUseCase: GetCapsulesUseCase

): ViewModel(){

    private val _state = mutableStateOf(CapsuleListState())
    val state : State<CapsuleListState> = _state

    init {
        getCapsules()
    }

    private fun getCapsules(){
        getCapsulesUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CapsuleListState(capsules = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CapsuleListState(error = result.message ?:
                    "An unexpected error occurred ")
                }
                is Resource.Loading -> {
                    _state.value = CapsuleListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}