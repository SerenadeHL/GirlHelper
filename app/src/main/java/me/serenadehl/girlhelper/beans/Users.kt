package me.serenadehl.girlhelper.beans

import com.avos.avoscloud.AVUser

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 17:29:00
 */
class Users : AVUser() {

    fun setNickname(nickname: String) = put("nickname", nickname)
    fun getNickname() = getString("nickname") ?: ""

    fun getHead() = getString("head") ?: ""
    fun setHead(head: String) = put("head", head)

    fun getBackground() = getString("background") ?: ""
    fun setBackground(background: String) = put("background", background)
}
