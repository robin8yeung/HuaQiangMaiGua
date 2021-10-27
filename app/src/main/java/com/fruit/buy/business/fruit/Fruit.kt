package com.fruit.buy.business.fruit

/**
 * 水果的设定
 * 成熟度由糖分成熟度和颜色成熟度组成，糖分成熟度必须要付款后才能拿到
 */
// 类取代类型码
abstract class Fruit(builder: Builder) {

    // 可变数据
    // 重构建议： 数据不应该被任意修改
    val weight: Int = builder.weight
    val ripeness: Ripeness = builder.ripeness ?: Ripeness(0.0, 0.0)

    abstract fun getUnitPrice(): Int

    abstract fun getDiscount(): Double

    fun getFinalUnitPrice(): Double = getUnitPrice() * getDiscount()

    fun getTotalPrice() = weight * getFinalUnitPrice()

    class Ripeness(
        val sugarRipeness: Double,
        val colorRipeness: Double
    ) {
        val value: Double
            get() = (sugarRipeness + colorRipeness) / 2f
    }

    abstract class Builder {
        var weight: Int = 0
        var ripeness: Ripeness? = null

        abstract fun build(): Fruit
    }
}