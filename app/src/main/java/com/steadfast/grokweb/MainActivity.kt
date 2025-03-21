package com.steadfast.grokweb

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.steadfast.grokweb.ui.theme.GrokwebTheme



class MainActivity : ComponentActivity() {

    @Composable
    fun MainActivityContent(savedInstanceState: Bundle?) {
        Column {
            TopBar()
            GrokWebView(savedInstanceState)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("GrokWebView", "onCreate")
        setContent {
            GrokwebTheme {
                MainActivityContent(savedInstanceState)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        /* Nothing here yet */
        Log.d("GrokWebView", "onStart")
    }

    override fun onResume() {
        super.onResume()
        /* Nothing here yet */
        Log.d("GrokWebView", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("GrokWebView", "onStop")
    }
}


