package me.serenadehl.girlhelper.extensions

import com.avos.avoscloud.AVException
import me.serenadehl.base.base.mvpbase.MVPBaseModel
import me.serenadehl.girlhelper.R

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-04 23:41:49
 */
fun MVPBaseModel.filterException(e: AVException?, success: () -> Unit, failure: () -> Unit) {
    if (e == null) {
        success()
    } else {
        when (e.code) {
            201 -> R.string.password_is_empty.toast()
            202 -> R.string.username_is_exists.toast()
            203 -> R.string.email_is_exists.toast()//电子邮箱地址已经被占用
            204 -> R.string.email_is_empty.toast()//没有提供电子邮箱地址
            205 -> R.string.email_user_not_found.toast() //找不到电子邮箱地址对应的用户
            210 -> R.string.username_does_not_match_password.toast()//用户名和密码不匹配
            211 -> R.string.user_not_found.toast()//找不到用户
            212 -> R.string.please_input_phone.toast()//请提供手机号码
            213 -> R.string.phone_user_not_found.toast()//手机号码对应的用户不存在
            214 -> R.string.phone_is_exists.toast()//手机号码已经被注册
            215 -> R.string.unverified_phone.toast()//未验证的手机号码
            216 -> R.string.unverified_email.toast()//未验证的邮箱地址
            217 -> R.string.invalid_username.toast()//无效的用户名，不允许空白用户名
            218 -> R.string.invalid_password.toast()//无效的密码，不允许空白密码
            219 -> R.string.login_fail_too_many_times.toast()//登录失败次数超过限制，请稍候再试，或者通过忘记密码重设密码
        }
        failure()
    }
}