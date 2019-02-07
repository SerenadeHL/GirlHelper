package me.serenadehl.girlhelper.mvp.splash

import me.serenadehl.base.base.mvpbase.IBaseView
import me.serenadehl.base.base.mvpbase.IBasePresenter
import me.serenadehl.base.base.mvpbase.IBaseModel

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-2-6 0:04:10
 */
interface ISplashView : IBaseView {
    fun close()
}

interface ISplashPresenter : IBasePresenter {
    fun loginBySessionToken()
}

interface ISplashModel : IBaseModel {
    fun loginBySessionToken(success: () -> Unit, failure: () -> Unit)
}
