package com.clinic.raamish.screen.detailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinic.raamish.bottomBorder
import com.clinic.raamish.ui.theme.TextFieldBorderDarkYellow
import com.clinic.raamish.ui.theme.urduFontFamily
import com.clinic.raamish.viewmodels.PatientViewModel

@Composable
fun PatientDetailTitleBarEdit(patientViewModel: PatientViewModel) {
    var name by remember { mutableStateOf(patientViewModel.selectPatient.name) }
    var address by remember { mutableStateOf(patientViewModel.selectPatient.address) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 20.dp, top = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .width(200.dp)
                .bottomBorder(2.dp, TextFieldBorderDarkYellow),
            textStyle = TextStyle(
                fontSize = 17.sp,
                fontFamily = urduFontFamily,
            ),
            singleLine = true,
        )
        BasicTextField(
            value = address,
            onValueChange = { address = it },
            modifier = Modifier
                .width(100.dp)
                .padding(top = 14.dp)
                .bottomBorder(1.dp, TextFieldBorderDarkYellow),
            textStyle = TextStyle(
                fontSize = 11.sp,
                fontFamily = urduFontFamily,
            ),
            singleLine = true,
        )
    }
}