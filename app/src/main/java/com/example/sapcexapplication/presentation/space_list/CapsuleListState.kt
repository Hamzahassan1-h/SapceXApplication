package com.example.sapcexapplication.presentation.space_list

import com.example.sapcexapplication.domain.model.Capsule

data class CapsuleListState(
    val isLoading: Boolean = false,
    val capsules: List<Capsule> = emptyList(),
    val error: String = " "
)
