package me.serenadehl.girlhelper.mvp.splash

import android.os.Bundle
import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVUser
import com.avos.avoscloud.LogInCallback
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import me.serenadehl.base.base.mvpbase.MVPBaseActivity
import me.serenadehl.base.extensions.startActivity
import me.serenadehl.base.utils.sharedpre.SPUtil
import me.serenadehl.girlhelper.R
import me.serenadehl.girlhelper.beans.Users
import me.serenadehl.girlhelper.constant.SPConst
import me.serenadehl.girlhelper.mvp.main.MainActivity
import me.serenadehl.girlhelper.utils.LoginUtils
import java.util.concurrent.TimeUnit

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-2-6 0:04:10
 */
class SplashActivity : MVPBaseActivity<ISplashPresenter>(), ISplashView {

    private lateinit var mDisposable: Disposable

    override fun layout() = R.layout.activity_splash

    override fun createPresenter() = SplashPresenter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        if (SPUtil.getBoolean(SPConst.FIRST_OPEN, true)) {
            mDisposable = Observable.timer(3, TimeUnit.SECONDS)
                .subscribe {
                    SPUtil.putBoolean(SPConst.FIRST_OPEN, false)
                    startActivity<MainActivity>()
                    finish()
                }
        } else {
            if (LoginUtils.hasSessionToken()) {
                mPresenter.loginBySessionToken()
            } else {
                close()
            }
        }
    }

    override fun close() {
        startActivity<MainActivity>()
        finish()
    }

    override fun onDestroy() {
        if (this@SplashActivity::mDisposable.isInitialized) {
            mDisposable.dispose()
        }
        super.onDestroy()
    }
}
