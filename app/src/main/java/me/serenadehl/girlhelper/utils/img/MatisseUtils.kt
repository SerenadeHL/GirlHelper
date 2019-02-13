package me.serenadehl.girlhelper.utils.img

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.IntentService
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.support.v4.app.Fragment
import android.util.Log
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.internal.entity.CaptureStrategy
import com.zhihu.matisse.listener.OnCheckedListener
import com.zhihu.matisse.listener.OnSelectedListener

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2019-02-07 19:11:30
 */
object MatisseUtils {
    private const val REQUEST_CODE_CHOOSE = 1
    private const val PICTURE_DIRECTORY = "GirlHelper"

    fun show(activity: Activity) {
        show(activity, 1)
    }

    fun show(activity: Activity, max: Int) {
        Matisse.from(activity)
            .choose(MimeType.ofImage())//选择类型
            .showSingleMediaType(true)//只显示一种类型，图片或者视频
            .countable(true)//显示已选择数量
            .capture(true)//允许拍照
            .maxSelectable(max)//最大选择数量
            .captureStrategy(
                CaptureStrategy(
                    true,
                    "me.serenadehl.girlhelper.fileprovider",
                    PICTURE_DIRECTORY
                )
            )//7.0权限适配以及拍照保存路径
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//竖屏
            .thumbnailScale(0.85f)//缩略图缩放比例
            .imageEngine(Glide4Engine())//Glide v4
            .forResult(REQUEST_CODE_CHOOSE)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, result: (imagePaths: List<String>) -> Unit) {
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            result(Matisse.obtainPathResult(data))
        }
    }
}
