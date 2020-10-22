package com.vimal.comic.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.vimal.core.ktx.AppCompatActivityKtx.enterFullScreen
import com.vimal.core.ktx.AppCompatActivityKtx.exitFullScreen
import com.vimal.core.ktx.AppCompatActivityKtx.viewBinding
import com.vimal.core.models.Action
import com.vimal.core.models.LoadingMessageData
import com.vimal.core.models.MessageData
import com.vimal.core.ui.BaseActivity
import com.vimal.comic.R
import com.vimal.comic.constants.Actions
import com.vimal.comic.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.isLoading = false
        binding.message = "Loading"
    }

    override fun onLoadingMessage(messageData: LoadingMessageData) {
        binding.isLoading = messageData.isLoading
        binding.message = messageData.getMessage()
    }

    override fun onInfoMessage(messageData: MessageData) {
        showDialog(messageData.getTitle(),
            messageData.getMessage(),
            messageData.getPositiveButton(),
        messageData.positiveAction,
        messageData.getNegativeButton(),
        messageData.negativeAction,
        messageData.getNeutralButton(),
        messageData.triggerActionOnDismiss,
        messageData.canDismiss)
    }

    override fun onPerformAction(action: Action) {
        when(action.task.action){
            Actions.ENTER_FULLSCREEN->{
                enterFullScreen(true)
            }
            Actions.EXIT_FULLSCREEN->{
                exitFullScreen()
            }
        }
    }

    private  fun showDialog(
        title: String? ,
        message: String?,
        positiveButton: String?,
        positiveAction: (() -> Unit)?,
        negativeButton: String?,
        negativeAction: (() -> Unit)?,
        neutralButton: String?,
        triggerActionOnDismiss: Boolean,
        canDismiss: Boolean
    ): AlertDialog {
        var isClicked = false
        val dialogBuilder = MaterialAlertDialogBuilder(this)
        dialogBuilder.setTitle(title)
        dialogBuilder.setMessage(message)
        positiveButton?.let {
            dialogBuilder.setPositiveButton(it) { dialog, _ ->
                isClicked = true
                positiveAction?.invoke()
                dialog?.dismiss()
            }
        }
        negativeButton?.let {
            dialogBuilder.setNegativeButton(it) { dialog, _ ->
                isClicked = true
                negativeAction?.invoke()
                dialog?.dismiss()
            }
        }

        neutralButton?.let {
            dialogBuilder.setNeutralButton(it) { dialog, _ ->
                isClicked = true
                dialog?.dismiss()
            }
        }
        if (negativeButton == null && positiveButton == null && neutralButton == null) {
            dialogBuilder.setNeutralButton(
                R.string.ok
            ) { dialog, _ ->
                isClicked = true
                dialog.dismiss()
            }
        }
        if (triggerActionOnDismiss) {
            dialogBuilder.setOnDismissListener {
                if (negativeAction != null && !isClicked) {
                    negativeAction.invoke()
                } else if (positiveAction != null && !isClicked) {
                    positiveAction.invoke()
                }
            }
        }
        dialogBuilder.setCancelable(canDismiss)
        val dialog = dialogBuilder.create()
        runOnUiThread { dialog.show() }
        return dialog
    }
}