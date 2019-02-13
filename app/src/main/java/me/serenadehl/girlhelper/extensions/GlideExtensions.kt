package me.serenadehl.girlhelper.extensions

import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 21:26:46
 */

fun ImageView.load(url: String, @DrawableRes res: Int) {
    Glide.with(context)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(res)
                .error(res)
        )
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.loadCircle(url: String, @DrawableRes res: Int) {
    Glide.with(context)
        .load(url)
        .apply(
            RequestOptions()
                .transform(CircleCrop())
                .placeholder(res)
                .error(res)
        )
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}