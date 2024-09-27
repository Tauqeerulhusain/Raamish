package com.clinic.raamish.screen.detailScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinic.raamish.bottomBorder
import com.clinic.raamish.ui.theme.HomePageBodyBrightYellow
import com.clinic.raamish.ui.theme.TextFieldBorderDarkYellow
import com.clinic.raamish.ui.theme.urduFontFamily
import com.clinic.raamish.viewmodels.PatientViewModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PatientDetailContentEdit(modifier: Modifier, patientViewModel: PatientViewModel) {
    val formattedModifiedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a").format(patientViewModel.selectPatient.modifiedDateObj)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(HomePageBodyBrightYellow)
            .padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            var mobileNo by remember { mutableStateOf(patientViewModel.selectPatient.mobileNo) }
            var age by remember { mutableStateOf(patientViewModel.selectPatient.age) }
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                BasicTextField(
                    value = mobileNo,
                    onValueChange = { mobileNo = it },
                    modifier = Modifier
                        .width(80.dp)
                        .padding(top = 2.dp)
                        .bottomBorder(1.dp, TextFieldBorderDarkYellow),
                    textStyle = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily.Serif,
                    ),
                    singleLine = true,
                )
            }
            BasicTextField(
                value = age,
                onValueChange = { age = it },
                modifier = Modifier
                    .width(30.dp)
                    .bottomBorder(1.dp, TextFieldBorderDarkYellow),
                textStyle = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily.Serif,
                ),
                singleLine = true,
            )
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Text(
                    formattedModifiedDate,
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.Serif
                )
            }
        }

        var desc by remember { mutableStateOf(patientViewModel.selectPatient.desc) }

        BasicTextField(
            value = desc,
            onValueChange = { desc = it },
            textStyle = TextStyle(
                fontSize = 15.sp,
                lineHeight = 33.sp,
                fontFamily = urduFontFamily,
            ),
        )
    }

}