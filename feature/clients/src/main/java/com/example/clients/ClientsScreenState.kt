package com.example.clients

import com.example.domain.models.Client

data class ClientsScreenState(
    val query: String = "",
    val clients: List<Client> = emptyList(),
    val isLoading: Boolean = false
)