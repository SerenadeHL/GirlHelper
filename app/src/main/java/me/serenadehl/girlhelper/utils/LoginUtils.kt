package me.serenadehl.girlhelper.utils

import android.text.TextUtils
import com.avos.avoscloud.AVUser
import me.serenadehl.base.extensions.saveToSP
import me.serenadehl.base.utils.sharedpre.SPUtil
import me.serenadehl.girlhelper.beans.Users
import me.serenadehl.girlhelper.constant.SPConst

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-04 20:02:05
 */
object LoginUtils {
    fun isUnLogin() = AVUser.getCurrentUser() == null

    fun getUser(): Users? = AVUser.getCurrentUser(Users::class.java)

    fun saveSessionToken() = getUser()?.sessionToken.saveToSP(SPConst.SESSION_TOKEN)

    fun hasSessionToken() = !TextUtils.isEmpty(SPUtil.getString(SPConst.SESSION_TOKEN))
}