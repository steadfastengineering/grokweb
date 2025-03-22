
package com.steadfast.webgrok

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings.COLOR_SCHEME_DARK
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class MainActivity : ComponentActivity() {

    private lateinit var geckoView: GeckoView
    private lateinit var geckoSession: GeckoSession
    private lateinit var geckoRuntime: GeckoRuntime
    private var viewSessionState: GeckoSession.SessionState? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        geckoView = findViewById(R.id.geckoview)
        geckoView.setBackgroundColor(Color.BLACK)
        geckoView.autofillEnabled = true
        geckoSession = GeckoSession()

        geckoRuntime = GeckoRuntime.create(this)
        geckoRuntime.settings.setPreferredColorScheme(COLOR_SCHEME_DARK)

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

    private fun createProgressDelegate(): GeckoSession.ProgressDelegate {
        return object : GeckoSession.ProgressDelegate {

            override fun onSessionStateChange( session: GeckoSession, sessionState: GeckoSession.SessionState) {
                super.onSessionStateChange(session, sessionState)
                // Anytime the session state changes, save it here.
                viewSessionState = sessionState
            }
        }
    }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    //sessionState = geckoSession.sessionState
    //outState.putParcelable("sessionState", sessionState)
}

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //sessionState = savedInstanceState.getParcelable("sessionState")
    }
}




//package com.steadfast.webgrok
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.appcompat.app.AppCompatActivity
//import org.mozilla.geckoview.GeckoRuntime
//import org.mozilla.geckoview.GeckoSession
//import org.mozilla.geckoview.GeckoView
//
//class MainActivity : ComponentActivity() {
//
//    private lateinit var geckoView: GeckoView
//    private lateinit var geckoSession: GeckoSession
//    private lateinit var geckoRuntime: GeckoRuntime
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_main)
//
//        geckoView = findViewById(R.id.geckoview)
//        geckoSession = GeckoSession()
//        geckoRuntime = GeckoRuntime.create(this)
//
//        geckoSession.open(geckoRuntime)
//        geckoView.setSession(geckoSession)
//        geckoSession.loadUri("https://google.com")
//
//    }
//}
