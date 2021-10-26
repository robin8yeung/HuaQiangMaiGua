package com.fruit.buy

import android.util.Log
import com.fruit.buy.business.Boss
import com.fruit.buy.business.LiuHuaQiang

@ExperimentalStdlibApi
object Main {

    fun main() {
        val liuHuaQiang = LiuHuaQiang()
        val boss = Boss()

        val targetFruit = liuHuaQiang.pickFruit(boss.fruits)
        // 重构建议： 卫语句取代嵌套
        if (targetFruit != null) {
            if (targetFruit.colorRipeness < 0.5) {
                liuHuaQiang.goAway()
            } else {
                // 散弹式修改
                // 重构建议： 抽出常量、接口
                Log.e("REFACTOR", "多少钱一斤")
                val unitPrice = boss.getUnitPrice(targetFruit.type) * boss.getDiscount(targetFruit.type, targetFruit.colorRipeness)
                Log.e("REFACTOR", "$unitPrice 块钱一斤")
                val notGo = liuHuaQiang.getBuyWilling(unitPrice)
                Log.e("REFACTOR", "都是大棚的瓜，你嫌贵我还嫌贵呢")
                if (notGo) {
                    Log.e("REFACTOR", "行，来一个")
                    val totalPrice = targetFruit.weight * unitPrice
                    boss.takeMoney(liuHuaQiang.wallet, totalPrice)
                    if (liuHuaQiang.getKillWilling(targetFruit.getRipeness())) {
                        liuHuaQiang.shot(boss)
                    } else {
                        liuHuaQiang.goAway()
                    }
                } else {
                    liuHuaQiang.goAway()
                }
            }
        } else {
            liuHuaQiang.goAway()
        }
    }
}