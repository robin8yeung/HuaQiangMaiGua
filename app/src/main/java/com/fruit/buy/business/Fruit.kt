package com.fruit.buy.business

/**
 * 水果的设定
 * 成熟度由糖分成熟度和颜色成熟度组成，糖分成熟度必须要付款后才能拿到
 */
data class Fruit(val type: Int) {
    companion object {
        const val TYPE_WATERMELON = 0
        const val TYPE_APPLE = 1
        const val TYPE_BANANA = 2
    }

    var weight: Int = 0
    var sugarRipeness = 0.0
    var colorRipeness = 0.0

    fun getRipeness(): Double = (sugarRipeness + colorRipeness) / 2f
}