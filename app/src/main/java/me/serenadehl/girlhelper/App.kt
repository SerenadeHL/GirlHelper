package me.serenadehl.girlhelper

import com.avos.avoscloud.AVOSCloud
import me.serenadehl.base.BaseApplication

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2018-11-13 19:04:14
 */
class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        //LeanCloud初始化
        AVOSCloud.initialize(this, "8OyP4VQki1FtOk1am4iO9VzT-gzGzoHsz", "QtkjmArImj7COpNTRYCSJQPV");
        AVOSCloud.setDebugLogEnabled(BuildConfig.DEBUG)
    }
}