
package com.steadfast.webgrok

import android.graphics.Color.BLACK
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoResult
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings.COLOR_SCHEME_DARK
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoSession.PromptDelegate.AutocompleteRequest
import org.mozilla.geckoview.GeckoSession.PromptDelegate.PromptResponse
import org.mozilla.geckoview.GeckoView


class MainActivity : AppCompatActivity() {

    lateinit var context:MainActivity
    private lateinit var geckoView: GeckoView
    private lateinit var geckoSession: GeckoSession
    private lateinit var geckoRuntime: GeckoRuntime
    private var viewSessionState: GeckoSession.SessionState? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Configure the view settings
        geckoView = findViewById(R.id.geckoview)
        geckoView.setBackgroundColor(BLACK)
        geckoView.autofillEnabled = true

        // Configure the session and runtime
        geckoSession = GeckoSession()
        geckoRuntime = GeckoRuntime.getDefault(context) // Does this prevent multiple runtimes from being created?
        geckoRuntime.settings.setPreferredColorScheme(COLOR_SCHEME_DARK)
        geckoRuntime.settings.setLoginAutofillEnabled(true)
        geckoRuntime.settings.setDoubleTapZoomingEnabled(false)
        geckoSession.open(geckoRuntime)
        geckoView.setSession(geckoSession)

        geckoSession.progressDelegate = createProgressDelegate()


        // Restore session state if available
        viewSessionState?.let {
            geckoSession.restoreState(it)
        } ?: run {
            geckoSession.loadUri("https://grok.com")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_item -> {
                // Handle About item click here
                Toast.makeText(this, "About item clicked!", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun createProgressDelegate(): GeckoSession.ProgressDelegate {
        return object : GeckoSession.ProgressDelegate {
            override fun onSessionStateChange( session: GeckoSession, sessionState: GeckoSession.SessionState) {
                super.onSessionStateChange(session, sessionState)
                // Anytime the Geckoview session state changes, save it here to our activity member.
                viewSessionState = sessionState
            }
        }
    }
}


