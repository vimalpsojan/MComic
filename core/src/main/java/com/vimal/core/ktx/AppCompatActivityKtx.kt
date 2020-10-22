package com.vimal.core.ktx

import android.os.Build
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

object AppCompatActivityKtx {

    inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
        crossinline bindingInflater: (LayoutInflater) -> T) =
        lazy(LazyThreadSafetyMode.NONE) {
            bindingInflater.invoke(layoutInflater)
        }

    private fun AppCompatActivity.enterFullScreenForSplash()
    {
        var flags=(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)
        flags=flags or View.SYSTEM_UI_FLAG_IMMERSIVE
        window.decorView.systemUiVisibility=flags
        supportActionBar?.hide()
    }

    /**
     * Enter activity to full screen
     */
    private fun AppCompatActivity.enterFullScreen()
    {
        var flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        flags=flags or View.SYSTEM_UI_FLAG_IMMERSIVE
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility=flags
        supportActionBar?.hide()
    }

    /**
     * Enter activity to full screen
     */
    fun AppCompatActivity.enterFullScreen(hideNavigation: Boolean=false)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.hide(WindowInsets.Type.statusBars())
            supportActionBar?.hide()
            if (hideNavigation) {
                window.insetsController?.hide(WindowInsets.Type.navigationBars())
            }
        }else{
            if(hideNavigation){
                enterFullScreenForSplash()
            }else{
                enterFullScreen()
            }
        }
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.

    /**
     * Exit Full screen for the activity
     */
    fun AppCompatActivity.exitFullScreen()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
            window.insetsController?.show(WindowInsets.Type.statusBars())
            window.insetsController?.show(WindowInsets.Type.navigationBars())
            supportActionBar?.show()
            window.insetsController?.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH
        }else{
            window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            supportActionBar?.show()
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

}