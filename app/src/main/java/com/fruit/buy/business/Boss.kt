package com.fruit.buy.business

import android.util.Log

data class Boss(private val name: String = "水果摊老板") {
    private var income = 0.0

    val fruits = listOf(
        Fruit(Fruit.TYPE_APPLE).apply {
            weight = 1
            sugarRipeness = 0.4
            colorRipeness = 0.3
        },
        Fruit(Fruit.TYPE_BANANA).apply {
            weight = 1
            sugarRipeness = 0.3
            colorRipeness = 0.4
        },
        Fruit(Fruit.TYPE_WATERMELON).apply {
            weight = 6
            sugarRipeness = 0.1
            colorRipeness = 0.6
        },
    )

    // 发散式变化
    // 依恋情节
    // Switch惊悚现身
    fun getUnitPrice(type: Int): Int = when(type) {
        Fruit.TYPE_APPLE -> 5
        Fruit.TYPE_BANANA -> 6
        Fruit.TYPE_WATERMELON -> 7
        else -> -1
    }

    // 发散式变化
    // 依恋情节
    // 基本类型偏执
    // Switch惊悚现身
    fun getDiscount(type: Int, colorRipeness: Double): Double = when(type) {
        Fruit.TYPE_APPLE -> colorRipeness
        Fruit.TYPE_BANANA -> colorRipeness * 0.8
        Fruit.TYPE_WATERMELON -> colorRipeness * 0.9
        else -> 1.0
    }

    // 依恋情节
    fun takeMoney(wallet: Wallet, money: Double) {
        income += wallet.pay(money)
        Log.e("REFACTOR", "老板的收入达到$income")
    }
}