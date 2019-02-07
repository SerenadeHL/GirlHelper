package me.serenadehl.girlhelper.mvp.login

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
import me.serenadehl.girlhelper.mvp.register.RegisterActivity

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-04 19:57:36
 */
@Suppress("DEPRECATION")
class LoginActivity : MVPBaseActivity<ILoginPresenter>(), ILoginView {
    private lateinit var mProgressDialog: ProgressDialog

    override fun layout() = R.layout.activity_login

    override fun createPresenter() = LoginPresenter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        btn_register.setOnClickListener {
            startActivity<RegisterActivity>()
        }

        btn_login.setOnClickListener {
            val account = tiet_account.text.toString()
            val password = tiet_password.text.toString()
            when {
                TextUtils.isEmpty(account) -> {
                    R.string.account_can_not_be_empty.toast()
                    return@setOnClickListener
                }
                account.length < 6 -> {
                    R.string.account_can_not_shorter_than_six.toast()
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
            mPresenter.login(account, password)
            mProgressDialog = ProgressDialog.show(this@LoginActivity, "登录", "登录中...")
        }
    }

    override fun hideLoading() {
        if (this@LoginActivity::mProgressDialog.isInitialized) {
            mProgressDialog.dismiss()
        }
    }

    override fun goHomepage() {
        startActivity<MainActivity>()
    }
}