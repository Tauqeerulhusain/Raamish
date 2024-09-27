package com.clinic.raamish.screen.homeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp


@Composable
fun Footer(showSearchBar: () -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                tint = Color.Gray
            )
        }
        IconButton(onClick = {
            showSearchBar()
            keyboardController?.show()
        }) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "Search...",
                tint = Color.Gray
            )
        }
    }
}