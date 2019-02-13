package me.serenadehl.girlhelper.mvp.main

import me.serenadehl.base.base.mvpbase.MVPBasePresenter
import me.serenadehl.girlhelper.R

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-2-6 0:04:10
 */
class MainPresenter : MVPBasePresenter<IMainView, IMainModel>(), IMainPresenter {

    override fun createModel() = MainModel()

    override fun setHead(imagePath: String) {
        mModel.setHead(imagePath, {
            //成功
            mView.get()?.showToast(R.string.head_upload_success)
            mView.get()?.refreshUserInfo()
        }, {
            //失败
            mView.get()?.showToast(R.string.head_upload_fail)
        })
    }

    override fun setBackground(imagePath: String) {
        mModel.setBackground(imagePath, {
            //成功
            mView.get()?.showToast(R.string.background_upload_success)
            mView.get()?.refreshUserInfo()
        }, {
            //失败
            mView.get()?.showToast(R.string.background_upload_fail)
        })
    }
}
