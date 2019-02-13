package me.serenadehl.girlhelper.mvp.main

import android.support.annotation.StringRes
import me.serenadehl.base.base.mvpbase.IBaseView
import me.serenadehl.base.base.mvpbase.IBasePresenter
import me.serenadehl.base.base.mvpbase.IBaseModel

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-2-6 0:04:10
 */
interface IMainView : IBaseView {
    fun showToast(@StringRes resId: Int)

    fun refreshUserInfo()
}

interface IMainPresenter : IBasePresenter {
    fun setHead(imagePath: String)

    fun setBackground(imagePath: String)
}

interface IMainModel : IBaseModel {
    fun setHead(imagePath: String, success: () -> Unit, failure: () -> Unit)

    fun setBackground(imagePath: String, success: () -> Unit, failure: () -> Unit)
}
