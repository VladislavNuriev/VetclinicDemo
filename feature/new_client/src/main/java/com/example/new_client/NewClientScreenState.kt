package com.example.new_client

data class NewClientScreenState(
    val phone: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)