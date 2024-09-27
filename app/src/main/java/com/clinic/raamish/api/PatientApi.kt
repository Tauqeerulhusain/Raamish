package com.clinic.raamish.api

import android.content.ContentValues
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.clinic.raamish.models.Patient
import com.clinic.raamish.models.User
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import kotlinx.coroutines.flow.MutableStateFlow
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class PatientApi @Inject constructor() {
    var database = Firebase.database("https://raameshtest-default-rtdb.asia-southeast1.firebasedatabase.app/")
    var patientListFLow = MutableStateFlow<List<Patient>>(emptyList())
    val result:ArrayList<Patient> = arrayListOf()

    fun getAllPatientList() {
        val myRef = database.getReference("list")
        myRef.addValueEventListener(object : ValueEventListener {
             @RequiresApi(Build.VERSION_CODES.O)
             override fun onDataChange(dataSnapshot: DataSnapshot) {
                 var patient: Patient?
                 var lastDate = ""
                try {
                    for(patientSnapshot in dataSnapshot.children){
                        patient = patientSnapshot.getValue<Patient>()
                        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        val formatterUtc = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSX")
                        if(!patient?.date.isNullOrBlank()){
                            lastDate = patient?.date!!
                        } else{
                            patient?.date = lastDate
                        }
                        if(patient?.modifiedDate.isNullOrBlank()){
                            patient?.modifiedDateObj = LocalDate.parse(patient?.date, formatter).atStartOfDay()
                        } else{
                            patient?.modifiedDateObj = LocalDateTime.parse(patient?.modifiedDate, formatterUtc)
                        }
                        result.add(patient!!)
                    }
                    patientListFLow.value = result.sortedByDescending { it.modifiedDateObj }
                }
                catch (exc: Exception){
                    println()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
    }

    fun getAllPatient(){
        val myRef = database.getReference("list")
        var patient: Patient?
        myRef.get().addOnSuccessListener {
            if (it.exists()){
                for(patientSnapshot in it.children){
                    patient = patientSnapshot.getValue<Patient>()
                }
            }
        }.addOnFailureListener{
        }
    }

    fun addPatient(){
        val myRef = database.getReference("Users")
        var phone1 = "92728374214"
        var phone2 = "80871391051"
        val users = User("Khalid",21)
        myRef.child(phone2).setValue(users).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Value is:")
        }.addOnFailureListener{
            Log.d(ContentValues.TAG, "Value is:")
        }
    }
}