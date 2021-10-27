package com.fruit.buy.business

import android.util.Log
import com.fruit.buy.business.fruit.Fruit
import com.fruit.buy.business.fruit.Watermelon

/**
 * 过长的类
 */
@ExperimentalStdlibApi
class LiuHuaQiang {
    init {
        Log.e(Constants.TAG, "有一个人前来买瓜")
    }

    // 重构建议：委托取代继承
    private val gunMan = GunMan(Gun())

    // 可变数据
    // 重构建议： 数据不应该被任意修改
    private val wallet = Wallet()

    fun pickFruit(fruits: List<Fruit>): Fruit? = fruits
        .firstOrNull { it is Watermelon }
        ?.also { Log.e(Constants.TAG, "选择了$it") }

    fun getBuyWilling(unitPrice: Double): Boolean {
        return if (unitPrice < 8) {
            Log.e(Constants.TAG, "What`s up. 你这瓜是金子做的还是瓜粒子是金子做的？")
            true
        } else {
            Log.e(Constants.TAG, "太贵了，我不买了")
            false
        }
    }

    fun getKillWilling(ripeness: Double) = ripeness < 0.5

    // 过长的函数
    // 重构建议： 提炼函数取代注释
    // 重构建议： 继承
    // 重构建议： 委托取代继承
    fun shot(target: Any) {
        gunMan.shot(target)
    }

    fun pay(money: Double): Double = wallet.pay(money)

    fun goAway() {
        Log.e(Constants.TAG, "走了")
    }
}