package com.steadfast.webgrok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.about_fragment, container, false)

        // Find views
        val appNameTextView: TextView = view.findViewById(R.id.appNameTextView)
        val buildStringTextView: TextView = view.findViewById(R.id.buildStringTextView)
        val sourceCodeTextView: TextView = view.findViewById(R.id.sourceCodeTextView)

        // Set content
        getString(R.string.app_name).also { appNameTextView.text = it }
        "Build: ${BuildConfig.BUILD_TYPE} - ${BuildConfig.VERSION_NAME}".also { buildStringTextView.text = it }
        "Source: ${BuildConfig.REPO_URL}".also { sourceCodeTextView.text = it }
        return view
    }
}
