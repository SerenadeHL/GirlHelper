package me.serenadehl.girlhelper.mvp.splash

import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVUser
import com.avos.avoscloud.LogInCallback
import me.serenadehl.base.base.mvpbase.MVPBaseModel
import me.serenadehl.base.utils.sharedpre.SPUtil
import me.serenadehl.girlhelper.beans.Users
import me.serenadehl.girlhelper.constant.SPConst
import me.serenadehl.girlhelper.extensions.filterException

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-2-6 0:04:10
 */
class SplashModel : MVPBaseModel(), ISplashModel {
    override fun loginBySessionToken(success: () -> Unit, failure: () -> Unit) {
        AVUser.becomeWithSessionTokenInBackground(
            SPUtil.getString(SPConst.SESSION_TOKEN),
            object : LogInCallback<Users>() {
                override fun done(user: Users?, e: AVException?) {
                    filterException(e, success, failure)
                }
            }, Users::class.java
        )
    }
}
