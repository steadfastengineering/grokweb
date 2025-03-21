package com.steadfast.grokweb

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.os.bundleOf

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GrokWebView(savedInstanceState: Bundle?) {

    val url by remember { mutableStateOf("https://www.grok.com") }
    val bundle: Bundle = rememberSaveable { bundleOf() }

    AndroidView(
        factory = { context ->
            WebView(context).apply{
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                settings.javaScriptEnabled = true
                settings.allowContentAccess = true
                settings.allowFileAccess = true
                settings.setSupportZoom(false)
                settings.builtInZoomControls = false
                settings.loadWithOverviewMode = true
                settings.domStorageEnabled = true
                settings.databaseEnabled = true
                settings.saveFormData = true
                webViewClient = WebViewClient()
            }
        },
        modifier = Modifier.fillMaxSize(),
        onRelease = { currentWebView ->
            currentWebView.saveState(bundle)
        },
        update = { webView ->
            if (bundle.isEmpty) {
                Log.d("GrokWebView", "loading url")
                webView.loadUrl(url)
            } else {
                Log.d("GrokWebView", "restoring state")
                webView.restoreState(bundle)
            }
        }
    )
}
