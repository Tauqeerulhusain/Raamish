package com.clinic.raamish.screen.homeScreen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.clinic.raamish.models.Patient
import com.clinic.raamish.ui.theme.AppBarGrey
import com.clinic.raamish.viewmodels.PatientViewModel


@Composable
fun HomeScreen(patientViewModel: PatientViewModel, onClick: (patient: Patient) -> Unit) {
    var isSearchBarVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            if (!isSearchBarVisible) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    HeaderTitle()
                }
            } else {
                HeaderSearch(patientViewModel) {
                    isSearchBarVisible = false
                    patientViewModel.clearSearch()
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(70.dp),
                containerColor = AppBarGrey,
            ) {
                Footer { isSearchBarVisible = true }
            }
        }
    ) { innerPadding ->
        PatientList(Modifier.padding(innerPadding), patientViewModel, onClick)
    }
}