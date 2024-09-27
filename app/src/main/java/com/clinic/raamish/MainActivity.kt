package com.clinic.raamish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.clinic.raamish.ui.theme.RaamishTheme
import com.clinic.raamish.viewmodels.PatientViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var patientViewModel: PatientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        var component = DaggerRaamishServiceComponent.builder().build()
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RaamishTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    PatientDetailScreen(patientViewModel)
                    NavigationController(patientViewModel)
                }
            }
        }
    }
}