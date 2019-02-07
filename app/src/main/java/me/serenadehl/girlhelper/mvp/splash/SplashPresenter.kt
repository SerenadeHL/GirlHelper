package me.serenadehl.girlhelper.mvp.splash

import me.serenadehl.base.base.mvpbase.MVPBasePresenter

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-2-6 0:04:10
 */
class SplashPresenter : MVPBasePresenter<ISplashView, ISplashModel>(), ISplashPresenter {

    override fun createModel() = SplashModel()

    override fun loginBySessionToken() {
        mModel.loginBySessionToken({
            //登录成功
            mView.get()?.close()
        }, {
            //登录失败
            mView.get()?.close()
        })
    }

}
