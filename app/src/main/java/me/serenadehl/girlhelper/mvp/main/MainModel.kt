package me.serenadehl.girlhelper.mvp.main

import com.avos.avoscloud.AVException
import com.avos.avoscloud.SaveCallback
import me.serenadehl.base.base.mvpbase.MVPBaseModel
import me.serenadehl.girlhelper.extensions.filterException
import me.serenadehl.girlhelper.extensions.saveToLeanCloud
import me.serenadehl.girlhelper.utils.LoginUtils
import java.io.File

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-2-6 0:04:10
 */
class MainModel : MVPBaseModel(), IMainModel {

    private fun saveUserInfo(success: () -> Unit, failure: () -> Unit) {
        LoginUtils.getUser()?.saveInBackground(object : SaveCallback() {
            override fun done(e: AVException?) {
                filterException(e, success, failure)
            }
        })
    }

    override fun setHead(imagePath: String, success: () -> Unit, failure: () -> Unit) {
        File(imagePath).saveToLeanCloud({ url ->
            LoginUtils.getUser()?.setHead(url)
            saveUserInfo(success, failure)
        }, failure)
    }

    override fun setBackground(imagePath: String, success: () -> Unit, failure: () -> Unit) {
        File(imagePath).saveToLeanCloud({ url ->
            LoginUtils.getUser()?.setBackground(url)
            saveUserInfo(success, failure)
        }, failure)
    }

}
