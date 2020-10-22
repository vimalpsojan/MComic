package com.vimal.comic.bindinghelper

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

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
        fun setUrl(imageView: ImageView, url:String)
        {
            Glide.with(imageView.context).load(url).fitCenter()
                .thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }
    }
}