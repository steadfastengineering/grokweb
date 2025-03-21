package com.steadfast.grokweb

import android.widget.Toast
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.R
import androidx.compose.ui.platform.LocalContext

fun onOptionsClicked(context: Context) {
    Toast.makeText(context, "Options clicked", Toast.LENGTH_SHORT).show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        navigationIcon = {},
        title = { Text("Grokweb") },
        actions = {
            IconButton(onClick = { onOptionsClicked(context) }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Settings"
                )
            }
        },
        modifier = modifier
    )
}
