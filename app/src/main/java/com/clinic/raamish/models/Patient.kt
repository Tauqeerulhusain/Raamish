package com.clinic.raamish.models

import java.time.LocalDateTime

data class Patient(
    var id: Int = 0,
    var name: String = "",
    var address: String = "",
    var age: String = "",
    var date: String = "",
    var modifiedDate: String = "",
    var modifiedDateObj: LocalDateTime? = null,
    var appointmentDate: String = "",
    var appointmentNote: String = "",
    var desc: String = "",
    var disease: String = "",
    var mobileNo: String = "",
    var isDeleted: Boolean = false,
)
