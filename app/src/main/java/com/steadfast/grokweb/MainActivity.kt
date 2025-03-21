package com.steadfast.grokweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.steadfast.grokweb.ui.theme.GrokwebTheme



class MainActivity : ComponentActivity() {

    @Composable
    fun MainActivityContent() {
        Column {
            TopBar()
            GrokWebView()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrokwebTheme {
                MainActivityContent()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        /* Nothing here yet */
    }

    override fun onResume() {
        super.onResume()
        /* Nothing here yet */
    }
}
