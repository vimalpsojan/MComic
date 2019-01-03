package com.srl.mob.mcomic.bindinghelper

import android.view.View
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Providing Custom Binding adapter for view
 */
class CustomBindingAdapter {
    companion object {
        @BindingAdapter("visibleGone")
        @JvmStatic
        fun showHide(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }

        /**
         * To enable data binding for SimpleDraweeView
         */
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setUrl(simpleDraweeView: SimpleDraweeView,url:String)
        {
            simpleDraweeView.setImageURI(url)
        }
    }
}