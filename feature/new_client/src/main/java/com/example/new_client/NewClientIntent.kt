package com.example.new_client

sealed interface NewClientIntent {
    data class InputPhone(val phone: String) : NewClientIntent
    data class InputFirstName(val firstName: String) : NewClientIntent
    data class InputLastName(val lastName: String) : NewClientIntent
    object SaveClient : NewClientIntent
    object ClearError : NewClientIntent
}