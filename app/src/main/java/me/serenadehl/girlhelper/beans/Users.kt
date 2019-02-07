package me.serenadehl.girlhelper.beans

import com.avos.avoscloud.AVUser

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 17:29:00
 */
class Users : AVUser() {
    fun getHead() = getString("head")
    fun setHead(head: String) = put("head", head)

    fun getBackgroud() = getString("background")
    fun setBackgroud(background: String) = put("background", background)
}
