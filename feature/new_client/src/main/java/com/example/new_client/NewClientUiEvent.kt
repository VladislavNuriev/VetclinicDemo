package com.example.new_client

sealed interface NewClientUiEvent {
    object ClientSaved : NewClientUiEvent
}