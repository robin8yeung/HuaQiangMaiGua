package com.fruit.buy.business

class GunMan(private var gun: Gun?) {
    fun releaseGun() {
        gun = null
    }

    fun shot(target: Any) {
        gun?.shot(target)
    }
}