package com.example.bmi_viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel: ViewModel() {
    var weightInput by mutableStateOf("")
    var heightInput by mutableStateOf("")

    var bodyMassIndex: Float = 0.0f
        get() {
            return calculate(weight, height)
        }

    private var weight: Float = 0.0f
        get(){
            return weightInput.toFloatOrNull() ?: 0.0f
        }

    private var height: Float = 0.0f
        get(){
            return heightInput.toFloatOrNull() ?: 0.0f
        }

    fun changeWeightInput(value: String) {
        weightInput = value
    }

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    private fun calculate (weight: Float, height: Float):Float {
        return if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}