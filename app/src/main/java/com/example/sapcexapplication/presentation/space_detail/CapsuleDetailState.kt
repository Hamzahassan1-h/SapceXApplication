package com.example.sapcexapplication.presentation.space_detail

import com.example.sapcexapplication.domain.model.Capsule

data class CapsuleDetailState(
    val isLoading: Boolean = false,
    val capsules: List<Capsule>? = null,
    val error: String = " "
)
