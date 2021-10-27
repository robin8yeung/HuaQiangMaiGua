package com.fruit.buy.business

import android.util.Log

@ExperimentalStdlibApi
class LiuHuaQiang {
    init {
        Log.e("REFACTOR", "有一个人前来买瓜")
    }

    private val gun = Gun()

    private val bulletHeads = listOf(
        BulletHead.generate(), BulletHead.generate(), BulletHead.generate(), BulletHead.generate(),
        BulletHead.generate(), BulletHead.generate(), BulletHead.generate(), BulletHead.generate(),
        BulletHead.generate(), BulletHead.generate(), BulletHead.generate(), BulletHead.generate(),
    )
    private val bulletBodies = listOf(
        BulletBody.generate(), BulletBody.generate(), BulletBody.generate(), BulletBody.generate(),
        BulletBody.generate(), BulletBody.generate(), BulletBody.generate(), BulletBody.generate(),
        BulletBody.generate(), BulletBody.generate(), BulletBody.generate(), BulletBody.generate(),
    )

    var wallet = Wallet()

    fun pickFruit(fruits: List<Fruit>): Fruit? = fruits
        .firstOrNull { it.type == Fruit.TYPE_WATERMELON }
        ?.also { Log.e("REFACTOR", "选择了$it") }

    fun getBuyWilling(unitPrice: Double): Boolean {
        return if (unitPrice < 8) {
            Log.e("REFACTOR", "What`s up. 你这瓜是金子做的还是瓜粒子是金子做的？")
            true
        } else {
            Log.e("REFACTOR", "太贵了，我不买了")
            false
        }
    }

    fun getKillWilling(ripeness: Double) = ripeness < 0.5

    fun shot(target: Any) {
        var bulletHead: BulletHead? = null
        var bulletBody: BulletBody? = null

        for(i in bulletBodies.indices) {
            if (bulletHead == null && i < bulletHeads.size) {
                if (bulletHeads[i].factor % 2 == 0) {
                    bulletHead = bulletHeads[i]
                }
            }

            if (bulletBody == null) {
                if (bulletBodies[i].factor % 2 == 0) {
                    bulletBody = bulletBodies[i]
                }
            }
        }

        if (bulletHead != null && bulletBody != null) {
            gun.fill(Bullet(bulletHead, bulletBody))
            gun.shot(target)
        }
    }

    fun goAway() {
        Log.e("REFACTOR", "走了")
    }
}