package me.serenadehl.girlhelper.mvp.main

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.avos.avoscloud.AVException
import com.avos.avoscloud.SaveCallback
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*
import me.serenadehl.base.base.BaseActivity
import me.serenadehl.base.base.mvpbase.MVPBaseActivity
import me.serenadehl.base.extensions.log
import me.serenadehl.base.extensions.startActivity
import me.serenadehl.base.extensions.toast
import me.serenadehl.girlhelper.R
import me.serenadehl.girlhelper.R.id.nv_navigation
import me.serenadehl.girlhelper.extensions.load
import me.serenadehl.girlhelper.extensions.loadCircle
import me.serenadehl.girlhelper.extensions.saveToLeanCloud
import me.serenadehl.girlhelper.mvp.login.LoginActivity
import me.serenadehl.girlhelper.utils.LoginUtils
import me.serenadehl.girlhelper.utils.img.MatisseUtils
import java.io.File

class MainActivity : MVPBaseActivity<IMainPresenter>(), IMainView {
    private lateinit var mNavigationHeader: View
    private lateinit var mTvUsername: TextView
    private lateinit var mIvBg: ImageView
    private lateinit var mIvHead: ImageView

    //更换头像还是背景
    private var mHead: Boolean = false

    override fun layout() = R.layout.activity_main

    override fun createPresenter() = MainPresenter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        mNavigationHeader = nv_navigation.getHeaderView(0)
        mTvUsername = mNavigationHeader.findViewById(R.id.tv_username)
        mIvBg = mNavigationHeader.findViewById(R.id.iv_bg)
        mIvHead = mNavigationHeader.findViewById(R.id.iv_head)
        mIvBg.setColorFilter(ContextCompat.getColor(this, R.color.color_66000000))
        mIvHead.setOnClickListener {
            if (LoginUtils.isUnLogin()) {
                startActivity<LoginActivity>()
            } else {
                RxPermissions(this@MainActivity)
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                    .subscribe { granted ->
                        if (granted) {
                            mHead = true
                            MatisseUtils.show(this@MainActivity)
                        } else {
                            toast(R.string.please_grant_necessary_permissions)
                        }
                    }
            }
        }
        mIvBg.setOnClickListener {
            if (LoginUtils.isUnLogin()) {
                startActivity<LoginActivity>()
            } else {
                RxPermissions(this@MainActivity)
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                    .subscribe { granted ->
                        if (granted) {
                            mHead = false
                            MatisseUtils.show(this@MainActivity)
                        } else {
                            toast(R.string.please_grant_necessary_permissions)
                        }
                    }
            }
        }
        nv_navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                //TODO 测试
                R.id.test -> toast(it.title.toString())
                R.id.settings -> startActivity<LoginActivity>()
            }
            dl_drawer.closeDrawers()
            true
        }
    }

    override fun onResume() {
        super.onResume()
        refreshUserInfo()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        MatisseUtils.onActivityResult(requestCode, resultCode, data) {
            val url = it[0]
            if (mHead) {
                mPresenter.setHead(url)
            } else {
                mPresenter.setBackground(url)
            }
        }
    }

    override fun showToast(resId: Int) {
        toast(resId)
    }

    override fun refreshUserInfo() {
        if (LoginUtils.isUnLogin()) return

        val user = LoginUtils.getUser()!!
        mTvUsername.text = user.getNickname().ifEmpty { user.username }
        mIvHead.loadCircle(user.getHead(), R.drawable.default_head)
        mIvBg.load(user.getBackground(), R.drawable.default_background)
    }
}
