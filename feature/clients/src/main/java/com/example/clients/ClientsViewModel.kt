package com.example.clients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetAllClientsUseCase
import com.example.domain.SearchClientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientsViewModel @Inject constructor(
    private val searchClient: SearchClientUseCase,
    private val getAllClients: GetAllClientsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ClientsScreenState())
    val state: StateFlow<ClientsScreenState> = _state.asStateFlow()

    private val query = MutableStateFlow("")

    init {
        query
            .onEach { input ->
                _state.update { it.copy(query = input) }
            }
            .flatMapLatest { input ->
                if (input.isBlank()) {
                    getAllClients()
                } else {
                    searchClient(input)
                }
            }
            .onEach { clients ->
                _state.update { it.copy(clients = clients) }
            }.launchIn(viewModelScope)

    }

    fun processIntent(intent: ClientsIntent) {
        viewModelScope.launch {
            when (intent) {
                is ClientsIntent.InputSearchQuery -> {
                    query.update { intent.query.trim() }
                }
            }
        }
    }
}