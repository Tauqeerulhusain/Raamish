package com.clinic.raamish.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clinic.raamish.models.Patient
import com.clinic.raamish.repository.PatientRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class PatientViewModel @Inject constructor(var patientRepository: PatientRepository) : ViewModel() {
    var patientListFLow = MutableStateFlow<List<Patient>>(emptyList())
        get() = patientRepository.patientListFLow
    var searchTextFlow = MutableStateFlow("")
    var selectPatient = Patient(
        12,
        "ندیم بن عقیلہ بانو",
        "گاندھی نگر",
        "۳۴",
        "10/06/2023",
        "2024-07-29T16:04:53.131Z",
        desc = "جریان ، سرعت انزال ،  پاخانہ  برابر ، ظنی دماغی کمزوری ،  نظر بد (گلونائن ) اور استخارہ میں بھی ۲    [     بیلا ، گلونائن   ۵     دانے    ۱  گھنٹہ      ؏     اغ حلوہ   فجرعشاء مع  دودھ   ایک چمچہ     ؏     معجون آردخرما 342 گ ، قسط شیریں ۲۰ گ(تھوڑاپانی )   ایک  چمچہ  بھر کر ظہر   ؏      ش ۲۷ ،   صبح شام      ]",
        mobileNo = "9637931320",
    )

    init {
        patientRepository.getAllPatientList()
    }

    @OptIn(FlowPreview::class)
    val searchResults: StateFlow<List<Patient>> =
        searchTextFlow
            .combine(patientListFLow) { searchTxt, patientLst ->
            when {
                searchTxt.isNotEmpty() -> patientLst.filter { patient ->
                    patient.name.contains(searchTxt, ignoreCase = true)
                }
                else -> patientLst
            }
        }.stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5_000)
        )

    fun onSearchEmitFlow(newQuery: String) {
        searchTextFlow.value = newQuery
    }

    fun clearSearch() {
        searchTextFlow.value = ""
    }
}