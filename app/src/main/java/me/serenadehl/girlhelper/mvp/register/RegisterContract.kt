package me.serenadehl.girlhelper.mvp.register

import me.serenadehl.base.base.mvpbase.IBaseModel
import me.serenadehl.base.base.mvpbase.IBasePresenter
import me.serenadehl.base.base.mvpbase.IBaseView

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-04 23:36:13
 */
interface IRegisterView : IBaseView {
    fun hideLoading()

    fun goHomepage()
}

interface IRegisterPresenter : IBasePresenter {
    fun register(account: String, password: String)
}

interface IRegisterModel : IBaseModel {
    fun register(account: String, password: String, success: () -> Unit, failure: () -> Unit)
}