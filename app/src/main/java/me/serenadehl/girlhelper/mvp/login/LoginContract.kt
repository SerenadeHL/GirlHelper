package me.serenadehl.girlhelper.mvp.login

import me.serenadehl.base.base.mvpbase.IBaseModel
import me.serenadehl.base.base.mvpbase.IBasePresenter
import me.serenadehl.base.base.mvpbase.IBaseView

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-04 23:36:13
 */
interface ILoginView : IBaseView {
    fun hideLoading()

    fun goHomepage()
}

interface ILoginPresenter : IBasePresenter {
    fun login(username: String, password: String)
}

interface ILoginModel : IBaseModel {
    fun login(username: String, password: String, success: () -> Unit, failure: () -> Unit)
}