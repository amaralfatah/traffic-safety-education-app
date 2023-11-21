package com.eduproject.trafficsafetyeducation.materi

//import android.app.Activity
//import android.content.res.Configuration
//import android.view.View
//import android.view.ViewGroup
//import android.webkit.WebChromeClient
//import android.webkit.WebView
//import androidx.core.view.isVisible
//import com.eduproject.trafficsafetyeducation.R
//
//class CustomWebChromeClient(private val activity: Activity) : WebChromeClient() {
//
//    private var customView: View? = null
//    private var customViewCallback: CustomViewCallback? = null
//    private var originalSystemUiVisibility = 0
//    private var originalOrientation = Configuration.ORIENTATION_UNDEFINED
//
//    override fun onShowCustomView(view: View, callback: CustomViewCallback) {
//        if (customView != null) {
//            callback.onCustomViewHidden()
//            return
//        }
//
//        customView = view
//        customViewCallback = callback
//        originalSystemUiVisibility = activity.window.decorView.systemUiVisibility
//        originalOrientation = activity.resources.configuration.orientation
//
//        // Set fullscreen layout parameters
//        val layoutParams = ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//        )
//        customView!!.layoutParams = layoutParams
//
//        // Hide status bar and action bar
//        activity.window.decorView.systemUiVisibility =
//            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
//                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
//                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
//                    View.SYSTEM_UI_FLAG_FULLSCREEN or
//                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//
//        // Change orientation to landscape if not already
//        if (originalOrientation == Configuration.ORIENTATION_PORTRAIT) {
//            activity.requestedOrientation = Configuration.ORIENTATION_LANDSCAPE
//        }
//
//        // Add the custom view to the decor view
//        val decorView = activity.window.decorView as ViewGroup
//        decorView.addView(customView)
//
//        // Hide the main WebView
//        val webView = decorView.findViewById<WebView>(R.id.webView)
//        webView.isVisible = false
//    }
//
//    override fun onHideCustomView() {
//        if (customView == null) {
//            return
//        }
//
//        // Show status bar and action bar
//        activity.window.decorView.systemUiVisibility = originalSystemUiVisibility
//
//        // Change orientation back to original
//        activity.requestedOrientation = originalOrientation
//
//        // Remove the custom view from the decor view
//        val decorView = activity.window.decorView as ViewGroup
//        decorView.removeView(customView)
//        customView = null
//        customViewCallback?.onCustomViewHidden()
//
//        // Show the main WebView
//        val webView = decorView.findViewById<WebView>(R.id.webView)
//        webView.isVisible = true
//    }
//}
