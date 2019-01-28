package com.srl.mob.mcomic.ui.frgments


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.srlbv.mob.commonbase.ktx.ActivityHelper.exitFullScreen
import com.srlbv.mob.commonbase.ktx.ActivityHelper.enterFullScreen
import com.srl.mob.mcomic.R


/**
 * A simple [Fragment] subclass.
 *
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).enterFullScreen()
        Handler().postDelayed({
            (activity as AppCompatActivity).exitFullScreen()
            findNavController().navigate(R.id.action_splash_to_comicList)

        },5*1000)
    }

}
