package com.clinic.raamish.screen.homeScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp


@Composable
fun TitleBar(){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Icon(
            modifier = Modifier
                .size(35.dp)
                .fillMaxWidth()
                .padding(end = 8.dp),
            imageVector = Icons.Rounded.Add,
            contentDescription = "Clinic Logo",
        )
        Text("Raamish Clinic")
    }
}