package com.clinic.raamish.screen.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clinic.raamish.bottomBorder
import com.clinic.raamish.models.Patient
import com.clinic.raamish.ui.theme.HomePageBodyBrightYellow
import com.clinic.raamish.viewmodels.PatientViewModel

@Composable
fun PatientList(
    modifier: Modifier = Modifier,
    patientViewModel: PatientViewModel,
    onClick: (patient: Patient) -> Unit
) {
    val searchResults by patientViewModel.searchResults.collectAsState()
    if (searchResults.isNotEmpty()) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(HomePageBodyBrightYellow)
                    .bottomBorder(1.dp, Color.LightGray),
            ) {
                items(searchResults) { patient ->
                    Text(
                        patient.name,
                        modifier = Modifier
                            .clickable { onClick(patient) }
                            .fillMaxWidth()
                            .padding(top = 4.dp, start = 11.dp)
                    )
                    Divider()
                }
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(1f)) {
            Text(text = "Loading...", style = MaterialTheme.typography.titleMedium)
        }
    }
}