package com.clinic.raamish

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clinic.raamish.screen.detailScreen.PatientDetailScreen
import com.clinic.raamish.screen.detailScreen.PatientDetailScreenEdit
import com.clinic.raamish.screen.homeScreen.HomeScreen
import com.clinic.raamish.viewmodels.PatientViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationController(patientViewModel: PatientViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(patientViewModel){
                patientViewModel.selectPatient = it
                navController.navigate("patientDetail")
            }
        }
        composable("patientDetail") {

            SelectionContainer {
                var isEditMode by remember { mutableStateOf(false) }
                if(isEditMode){
                    PatientDetailScreenEdit(patientViewModel){
                        isEditMode = false
                    }
                } else{
                    PatientDetailScreen(patientViewModel){
                        isEditMode = true
                    }
                }
            }
        }
//        composable<Patient> { backStackEntry ->
//            val patient: Patient = backStackEntry.toRoute()
//
//            PatientDetailScreen(patient)
//        }
//        composable("patientDetail/{patient}", arguments = listOf(
//            navArgument("patient") {
//                type = NavType.ReferenceType
//            }
//        )) {
//            var selectedExtrasOption = it.arguments!!.("patient")
//            WebViewScaffold(selectedExtrasOption!!) {
//                navController.popBackStack()
//            }
//        }
    }
}