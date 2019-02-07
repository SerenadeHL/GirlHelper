package me.serenadehl.girlhelper.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 21:26:46
 */

fun ImageView.load(url: String) = Glide.with(context).load(url).into(this)

fun ImageView.load(resId: Int) = Glide.with(context).load(resId).into(this)

fun ImageView.loadCircle(url: String) =
    Glide.with(context).load(url).apply(RequestOptions().transform(CircleCrop())).into(this)

fun ImageView.loadCircle(resId: Int) =
    Glide.with(context).load(resId).apply(RequestOptions().transform(CircleCrop())).into(this)
