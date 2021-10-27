package com.fruit.buy.business

import android.util.Log

/**
 * 子弹设定1：子弹由子弹头和子弹体组合而成，2这需满足一定条件，否则会导致炸膛
 * 子弹设定2：子弹射击前需要预热，根据版本不同，有2中预热方式
 * 子弹设定3：子弹使用完后会销毁，但区分是否引起炸膛2种情况
 */
class Bullet(
    private val head: BulletHead,
    private val body: BulletBody
) {

    init {
        Log.e(Constants.TAG, "子弹 head $head body $body")
    }

    fun fire() {
        // 重构建议： 分解/合并条件表达式
        if (isSafe()) {
            fireForSafe()
        } else {
            fireForDangerous()
        }
    }

    private fun fireForDangerous() {
        destroyForDangerous()
        throw RuntimeException("子弹炸膛了！！")
    }

    private fun fireForSafe() {
        if (body.factor / 9 > 3) {
            prepare()
        } else {
            prepareForNewVersion()
        }
        destroy()
        Log.e(Constants.TAG, "子弹射击！！")
    }

    private fun isSafe() = head.factor % 2 == 0 && body.factor % 2 == 0

    // 重构建议： 移除标记参数
    private fun prepare() {
        Log.e(Constants.TAG, "子弹预热")
    }

    private fun prepareForNewVersion() {
        Log.e(Constants.TAG, "新版本子弹预热")
    }

    // 重构建议： 移除标记参数
    private fun destroy() {
        Log.e(Constants.TAG, "子弹正常销毁")
    }

    private fun destroyForDangerous() {
        Log.e(Constants.TAG, "子弹非正常销毁")
    }
}