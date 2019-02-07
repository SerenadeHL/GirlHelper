package me.serenadehl.girlhelper.mvp.login

import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVUser
import com.avos.avoscloud.LogInCallback
import me.serenadehl.base.base.mvpbase.MVPBaseModel
import me.serenadehl.girlhelper.beans.Users
import me.serenadehl.girlhelper.extensions.filterException


/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-04 19:59:38
 */
class LoginModel : MVPBaseModel(), ILoginModel {
    override fun login(username: String, password: String, success: () -> Unit, failure: () -> Unit) {
        AVUser.logInInBackground(username, password, object : LogInCallback<Users>() {
            override fun done(user: Users?, e: AVException?) {
                filterException(e, success, failure)
            }
        }, Users::class.java)
    }
}