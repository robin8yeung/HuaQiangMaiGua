package com.fruit.buy.business

import android.util.Log

class Gun {
    private var bullet: Bullet? = null

    fun fill(bullet: Bullet) {
        this.bullet = bullet
    }

    fun shot(target: Any) {
        Log.e(Constants.TAG, "瞄准 $target!")
        bullet?.fire()
    }
}