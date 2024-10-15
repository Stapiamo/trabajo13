package com.example.trabajo13.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.trabajo13.Modal.Imc


class IMCViewModel : ViewModel() {
    var state = mutableStateOf(Imc())
        private set

    fun updatePeso(peso: String) {
        state.value = state.value.copy(peso = peso)
    }

    fun updateAlto(alto: String) {
        state.value = state.value.copy(alto = alto)
    }

    fun updateEdad(edad: String) {
        state.value = state.value.copy(edad = edad)
    }

    fun validateFields(): Boolean {
        val pesoValue = state.value.peso.toFloatOrNull()
        val altoValue = state.value.alto.toFloatOrNull()
        val edadValue = state.value.edad.toIntOrNull()

        return pesoValue != null && pesoValue > 0 &&
                altoValue != null && altoValue > 0 &&
                edadValue != null && edadValue > 0
    }

    fun calculateIMC() {
        val pesoValue = state.value.peso.toFloatOrNull() ?: 0f
        val altoValue = state.value.alto.toFloatOrNull()?.div(100) ?: 0f
        val imcResult = if (altoValue > 0) pesoValue / (altoValue * altoValue) else 0f
        state.value = state.value.copy(imcResult = imcResult)
    }
}