package me.serenadehl.girlhelper.mvp.register

import me.serenadehl.base.base.mvpbase.MVPBasePresenter
import me.serenadehl.girlhelper.R
import me.serenadehl.girlhelper.extensions.toast
import me.serenadehl.girlhelper.utils.LoginUtils

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 20:29:20
 */
class RegisterPresenter : MVPBasePresenter<IRegisterView, IRegisterModel>(), IRegisterPresenter {
    override fun createModel() = RegisterModel()

    override fun register(username: String, password: String) {
        mModel.register(username, password, {
            //注册成功
            LoginUtils.saveSessionToken()
            mView.get()?.goHomepage()
            R.string.register_success.toast()
        }, {
            //注册失败
            mView.get()?.hideLoading()
        })
    }
}