package com.example.bmi_viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi_viewmodel.ui.theme.BMI_ViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMI_ViewModelTheme {
                BodyMassIndex()
            }
        }
    }
}

@Composable
fun BodyMassIndex(bmiViewModel: BMIViewModel = viewModel()){
    Column (
        modifier = Modifier.padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = bmiViewModel.weightInput,
            onValueChange = {bmiViewModel.changeWeightInput(it)},
            label = { Text(text="Aseta paino")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        TextField(
            value = bmiViewModel.heightInput,
            onValueChange = {bmiViewModel.changeHeightInput(it)},
            label = { Text(text="Aseta pituus metreinä")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Text(text= stringResource(R.string.body_mass_index, bmiViewModel.bodyMassIndex))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMI_ViewModelTheme {
        BodyMassIndex()
    }
}