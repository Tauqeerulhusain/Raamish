package com.clinic.raamish.repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.clinic.raamish.api.PatientApi
import com.clinic.raamish.models.Patient
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class PatientRepository @Inject constructor(var patientApi: PatientApi) {
    var patientListFLow = MutableStateFlow<List<Patient>>(emptyList())
        get() = patientApi.patientListFLow

    fun getAllPatientList(){
        patientApi.getAllPatientList()
    }
}