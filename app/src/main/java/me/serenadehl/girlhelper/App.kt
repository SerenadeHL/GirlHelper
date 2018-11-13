package me.serenadehl.girlhelper

import me.serenadehl.base.BaseApplication

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2018-11-13 19:04:14
 */
class App :BaseApplication() {
    override fun isDebug() = BuildConfig.DEBUG

    override fun onCreate() {
        super.onCreate()
    }
}