package com.clinic.raamish.screen.homeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clinic.raamish.headerBottomBorder
import com.clinic.raamish.ui.theme.AppBarGrey
import com.clinic.raamish.viewmodels.PatientViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderSearch(patientViewModel: PatientViewModel, onBackSwipe: () -> Unit) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .headerBottomBorder(1.dp, Color.LightGray),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar(onBackSwipe, patientViewModel)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(AppBarGrey),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderTitle() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .headerBottomBorder(1.dp, Color.LightGray),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TitleBar()
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(AppBarGrey),
    )
}