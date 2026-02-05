package com.example.clients

sealed interface ClientsIntent {
    data class InputSearchQuery(val query: String) : ClientsIntent
}