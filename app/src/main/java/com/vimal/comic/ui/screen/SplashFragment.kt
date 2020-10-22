package com.vimal.comic.ui.screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.vimal.core.models.Action
import com.vimal.core.ui.BaseFragment
import com.vimal.core.utils.viewBinding
import com.vimal.comic.R
import com.vimal.comic.constants.Actions
import com.vimal.comic.databinding.FragmentSplashBinding
import com.vimal.comic.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel>(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)
    override val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        viewModel.performAction(Action(Intent(Actions.ENTER_FULLSCREEN),null))
    }

    override fun onPause() {
        super.onPause()
        viewModel.performAction(Action(Intent(Actions.EXIT_FULLSCREEN),null))
    }

}