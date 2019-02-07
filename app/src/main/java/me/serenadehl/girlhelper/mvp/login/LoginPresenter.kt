package me.serenadehl.girlhelper.mvp.login

import me.serenadehl.base.base.mvpbase.MVPBasePresenter
import me.serenadehl.girlhelper.R
import me.serenadehl.girlhelper.extensions.toast
import me.serenadehl.girlhelper.utils.LoginUtils

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-04 19:59:21
 */
class LoginPresenter : MVPBasePresenter<ILoginView, ILoginModel>(), ILoginPresenter {
    override fun createModel() = LoginModel()

    override fun login(username: String, password: String) {
        mModel.login(username, password, {
            //登录成功
            LoginUtils.saveSessionToken()
            mView.get()?.goHomepage()
            R.string.login_success.toast()
        }, {
            //登录失败
            mView.get()?.hideLoading()
        })
    }
}