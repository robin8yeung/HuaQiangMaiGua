package com.fruit.buy.business

import android.util.Log
import com.fruit.buy.business.fruit.Apple
import com.fruit.buy.business.fruit.Banana
import com.fruit.buy.business.fruit.Fruit
import com.fruit.buy.business.fruit.Watermelon

data class Boss(private val name: String = "水果摊老板") {
    private var income = 0.0

    val fruits = listOf(
        Apple.Builder().apply {
            weight = 1
            ripeness = Fruit.Ripeness(0.4, 0.3)
        }.build(),
        Banana.Builder().apply {
            weight = 1
            ripeness = Fruit.Ripeness(0.3, 0.4)
        }.build(),
        Watermelon.Builder().apply {
            weight = 6
            ripeness = Fruit.Ripeness(0.1, 0.6)
        }.build()
    )

    fun takeMoney(money: Double) {
        income += money
        Log.e(Constants.TAG, "老板的收入达到$income")
    }
}