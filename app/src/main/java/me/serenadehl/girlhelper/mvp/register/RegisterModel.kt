package me.serenadehl.girlhelper.mvp.register

import me.serenadehl.base.base.mvpbase.IBaseModel
import com.avos.avoscloud.AVException
import com.avos.avoscloud.SignUpCallback
import com.avos.avoscloud.AVUser
import me.serenadehl.base.base.mvpbase.MVPBaseModel
import me.serenadehl.girlhelper.beans.Users
import me.serenadehl.girlhelper.extensions.filterException


/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 20:28:36
 */
class RegisterModel : MVPBaseModel(), IRegisterModel {
    override fun register(account: String, password: String, success: () -> Unit, failure: () -> Unit) {
        Users().apply {
            username = account
            setPassword(password)
        }.signUpInBackground(object : SignUpCallback() {
            override fun done(e: AVException?) {
                filterException(e, success, failure)
            }
        })
    }

}