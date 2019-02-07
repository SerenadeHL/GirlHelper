package me.serenadehl.girlhelper.extensions

import android.widget.Toast
import me.serenadehl.base.utils.app.AppManager

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 12:29:09
 */
fun String.toast() = Toast.makeText(AppManager.instance.currentActivity.applicationContext, this, Toast.LENGTH_SHORT).show()

fun Int.toast() = Toast.makeText(AppManager.instance.currentActivity.applicationContext, this, Toast.LENGTH_SHORT).show()