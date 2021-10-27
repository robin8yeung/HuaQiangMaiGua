package com.fruit.buy.business

import android.util.Log

class GunMan(private var gun: Gun) {

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

    // 委托取代超类
    // 如果刘华强作为一个功能较复杂的类，如果继承了GunMan，那如果还有其他业务功能要封装起来（除了抢手还有其他身份），就无法再进行继承
    // 其次，如果GunMan除了在这个业务，还有其他业务用到，需要实现其他的一些业务，比如提交枪出去审查，
    // 但刘华强并不希望care这些具体步骤，则既不应该暴露出去（继承后，这个函数也成了刘华强的public函数），也不应该专门去实现他
    // 总的来说，如果一个类不是为抽象而设计的，就不要让它能被继承
    fun testGun() {
        Log.e(Constants.TAG, "已提交 $gun 进行了审查")
    }

    fun shot(target: Any) {
        generateSafeBullet()?.let {
            fillAndShot(it, target)
        }
    }

    private fun fillAndShot(bullet: Bullet, target: Any) {
        gun.fill(bullet)
        gun.shot(target)
    }

    private fun generateSafeBullet(): Bullet? {
        // 重构建议： 拆分循环
        // 重构建议： 管道取代遍历
        val bulletHead = bulletHeads.firstOrNull { it.factor % 2 == 0 }
        val bulletBody = bulletBodies.firstOrNull { it.factor % 2 == 0 }
        return if (bulletHead != null && bulletBody != null) {
            Bullet(bulletHead, bulletBody)
        } else null
    }

}