package me.serenadehl.girlhelper.mvp.main

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import me.serenadehl.base.base.BaseActivity
import me.serenadehl.base.extensions.startActivity
import me.serenadehl.girlhelper.R
import me.serenadehl.girlhelper.extensions.load
import me.serenadehl.girlhelper.extensions.loadCircle
import me.serenadehl.girlhelper.mvp.login.LoginActivity
import me.serenadehl.girlhelper.utils.LoginUtils

class MainActivity : BaseActivity() {
    private lateinit var mNavigationHeader: View
    private lateinit var mTvUsername: TextView
    private lateinit var mIvBg: ImageView
    private lateinit var mIvHead: ImageView

    override fun layout() = R.layout.activity_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        mNavigationHeader = nv_navigation.getHeaderView(0)
        mTvUsername = mNavigationHeader.findViewById(R.id.tv_username)
        mIvBg = mNavigationHeader.findViewById(R.id.iv_bg)
        mIvHead = mNavigationHeader.findViewById(R.id.iv_head)
        mIvBg.setColorFilter(ContextCompat.getColor(this, R.color.color_66000000))
        mNavigationHeader.setOnClickListener {
            if (LoginUtils.isUnLogin()) {
                startActivity<LoginActivity>()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (LoginUtils.isUnLogin()) return

        val user = LoginUtils.getUser()!!
        user.setHead("http://lc-8oyp4vqk.cn-n1.lcfile.com/XSvxmPz1QpNOncd1ez4KaRmSN1351NV94YO5oPX4.jpg")
        user.setBackgroud("http://lc-8oyp4vqk.cn-n1.lcfile.com/ubyuTUykWjI0u5qbRFk5bp5ibB2JqRJ28ufkAUkb.jpg")
        mTvUsername.text = user.username
        val head = user.getHead()
        if (TextUtils.isEmpty(head)) {
            mIvHead.loadCircle(R.drawable.default_head)
        } else {
            mIvHead.loadCircle(head!!)
        }
        val background = user.getBackgroud()
        if (TextUtils.isEmpty(background)) {
            mIvBg.load(R.drawable.default_background)
        } else {
            mIvBg.load(background)
        }
    }
}
