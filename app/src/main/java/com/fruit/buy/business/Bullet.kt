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
        Log.e("REFACTOR", "子弹 head $head body $body")
    }

    fun fire() {
        if (head.factor % 2 == 0 && body.factor % 2 == 0) {
            if (body.factor / 9 > 3) {
                prepare(false)
            } else {
                prepare(true)
            }
            destroy(false)
            Log.e("REFACTOR", "子弹射击！！")
        } else {
            destroy(true)
            throw RuntimeException("子弹炸膛了！！")
        }
    }

    private fun prepare(newVersion: Boolean) {
        if (newVersion) {
            Log.e("REFACTOR", "新版本子弹预热")
        } else {
            Log.e("REFACTOR", "子弹预热")
        }
    }

    private fun destroy(dangerous: Boolean) {
        if (dangerous) {
            Log.e("REFACTOR", "子弹非正常销毁")
        } else {
            Log.e("REFACTOR", "子弹正常销毁")
        }
    }
}