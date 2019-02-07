package me.serenadehl.girlhelper.mvp.register

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_login.*
import me.serenadehl.base.base.mvpbase.MVPBaseActivity
import me.serenadehl.base.extensions.hideKeyboard
import me.serenadehl.base.extensions.startActivity
import me.serenadehl.girlhelper.R
import me.serenadehl.girlhelper.extensions.toast
import me.serenadehl.girlhelper.mvp.main.MainActivity

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-05 20:27:23
 */
@Suppress("DEPRECATION")
class RegisterActivity : MVPBaseActivity<IRegisterPresenter>(), IRegisterView {
    private lateinit var mProgressDialog: ProgressDialog

    override fun createPresenter() = RegisterPresenter()

    override fun layout() = R.layout.activity_register

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        btn_register.setOnClickListener {
            val username = tiet_username.text.toString()
            val password = tiet_password.text.toString()
            when {
                TextUtils.isEmpty(username) -> {
                    R.string.username_can_not_be_empty.toast()
                    return@setOnClickListener
                }
                username.length < 6 -> {
                    R.string.username_can_not_shorter_than_six.toast()
                    return@setOnClickListener
                }

                TextUtils.isEmpty(password) -> {
                    R.string.password_can_not_be_empty.toast()
                    return@setOnClickListener
                }
                password.length < 6 -> {
                    R.string.password_can_not_shorter_than_six.toast()
                    return@setOnClickListener
                }
            }
            hideKeyboard(currentFocus!!)
            mPresenter.register(username, password)
            mProgressDialog = ProgressDialog.show(this@RegisterActivity, "注册", "注册中...")
        }
    }

    override fun hideLoading() {
        if (this@RegisterActivity::mProgressDialog.isInitialized) {
            mProgressDialog.dismiss()
        }
    }

    override fun goHomepage() {
        startActivity<MainActivity>()
    }
}