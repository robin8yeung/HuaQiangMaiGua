package com.fruit.buy

import android.util.Log
import com.fruit.buy.business.Boss
import com.fruit.buy.business.Constants
import com.fruit.buy.business.LiuHuaQiang
import com.fruit.buy.business.fruit.Fruit

@ExperimentalStdlibApi
object Main {

    fun main() {
        val liuHuaQiang = LiuHuaQiang()
        val boss = Boss()
        // 重构建议： 卫语句取代嵌套
        val fruit = pickFruit(liuHuaQiang, boss)
        if (fruit == null) {
            liuHuaQiang.goAway()
            return
        }
        if (!buyFruit(fruit, liuHuaQiang, boss)) {
            liuHuaQiang.goAway()
            return
        }
        if (checkFruit(liuHuaQiang, fruit, boss)) {
            liuHuaQiang.goAway()
        }
    }

    private fun checkFruit(liuHuaQiang: LiuHuaQiang, fruit: Fruit, boss: Boss): Boolean {
        if (!liuHuaQiang.getKillWilling(fruit.ripeness.value)) {
            return true
        }
        Log.e(Constants.TAG, "你这瓜不熟")
        liuHuaQiang.shot(boss)
        return false
    }

    private fun buyFruit(fruit: Fruit, liuHuaQiang: LiuHuaQiang, boss: Boss): Boolean {
        // 散弹式修改
        // 重构建议： 抽出常量、接口
        Log.e(Constants.TAG, "多少钱一斤")

        // 神秘命名
        // 重构建议：重命名变量
        // 临时字段
        // 重构建议：查询取代临时变量，内联变量
        if (!liuHuaQiang.getBuyWilling(
                // 重构建议：数据类处理自己的数据
                fruit.getFinalUnitPrice().also {
                    Log.e(Constants.TAG, "$it 块钱一斤")
                })) {
            return false
        }
        Log.e(Constants.TAG, "都是大棚的瓜，你嫌贵我还嫌贵呢")
        Log.e(Constants.TAG, "行，来一个")

        // 依恋情节
        // 重构建议： 合理处理类之间的关系
        boss.takeMoney(liuHuaQiang.pay(
            // 重构建议：数据类处理自己的数据
            fruit.getTotalPrice()))
        return true
    }

    private fun pickFruit(liuHuaQiang: LiuHuaQiang, boss: Boss): Fruit? {
        val targetFruit = liuHuaQiang.pickFruit(boss.fruits) ?: return null
        if (doesNotLookRipe(targetFruit)) {
            return null
        }
        return targetFruit
    }

    private fun doesNotLookRipe(targetFruit: Fruit) =
        targetFruit.ripeness.colorRipeness < 0.5
}