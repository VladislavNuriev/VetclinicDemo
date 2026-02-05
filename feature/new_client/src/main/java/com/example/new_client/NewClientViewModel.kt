package com.example.new_client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Client
import com.example.domain.InsertClientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewClientViewModel @Inject constructor(
    private val insertClient: InsertClientUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NewClientScreenState())
    val state: StateFlow<NewClientScreenState> = _state.asStateFlow()

    private val _uiEvent = MutableStateFlow<NewClientUiEvent?>(null)
    val uiEvent: StateFlow<NewClientUiEvent?> = _uiEvent.asStateFlow()

    fun processIntent(intent: NewClientIntent) {
        when (intent) {
            is NewClientIntent.InputPhone -> {
                _state.update { it.copy(phone = intent.phone) }
            }
            is NewClientIntent.InputFirstName -> {
                _state.update { it.copy(firstName = intent.firstName) }
            }
            is NewClientIntent.InputLastName -> {
                _state.update { it.copy(lastName = intent.lastName) }
            }
            NewClientIntent.SaveClient -> {
                saveClient()
            }
            NewClientIntent.ClearError -> {
                _state.update { it.copy(error = null) }
            }
        }
    }

    private fun saveClient() {
        val state = _state.value

        // Валидация
        val validationResult = validateClient(state)
        if (!validationResult.isValid) {
            _state.update { it.copy(error = validationResult.errorMessage) }
            return
        }

        viewModelScope.launch {
            try {
                val client = Client(
                    phone = state.phone,
                    firstName = state.firstName.trim(),
                    lastName = state.lastName.trim(),
                    medicalCards = emptyList()
                )
                insertClient(client)
                _uiEvent.value = NewClientUiEvent.ClientSaved
                clearForm()
            } catch (e: Exception) {
                _state.update { it.copy(error = "Ошибка сохранения: ${e.message}") }
            }
        }
    }

    private fun validateClient(state: NewClientScreenState): ValidationResult {
        return when {
            state.phone.isBlank() -> ValidationResult(
                isValid = false,
                errorMessage = "Введите номер телефона"
            )
            state.phone.length < 10 -> ValidationResult(
                isValid = false,
                errorMessage = "Номер телефона должен содержать не менее 10 цифр"
            )
            state.firstName.isBlank() -> ValidationResult(
                isValid = false,
                errorMessage = "Введите имя"
            )
            state.lastName.isBlank() -> ValidationResult(
                isValid = false,
                errorMessage = "Введите фамилию"
            )
            else -> ValidationResult(isValid = true)
        }
    }

    private fun clearForm() {
        _state.update {
            NewClientScreenState(
                phone = "",
                firstName = "",
                lastName = ""
            )
        }
    }

    fun clearUiEvent() {
        _uiEvent.value = null
    }
}

private data class ValidationResult(
    val isValid: Boolean,
    val errorMessage: String? = null
)