package com.vimal.core.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.vimal.core.models.Action
import com.vimal.core.models.LoadingMessageData
import com.vimal.core.models.MessageData
import com.vimal.core.utils.EventObserver
import com.vimal.core.viewmodel.BaseActivityViewModel

abstract class BaseActivity : AppCompatActivity() {

    var isPaused = false

    private val viewModel:BaseActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.action.observe(this,EventObserver{
            onPerformAction(it)
        })
        viewModel.infoMessage.observe(this,EventObserver{
            onInfoMessage(it)
        })
        viewModel.loading.observe(this,EventObserver{
            onLoadingMessage(it)
        })
    }

    fun actionPerformed(action:Action){
        viewModel.actionPerformed(action)
    }

    abstract fun onLoadingMessage(messageData: LoadingMessageData)
    abstract fun onInfoMessage(messageData: MessageData)

    abstract fun onPerformAction(action: Action)

}