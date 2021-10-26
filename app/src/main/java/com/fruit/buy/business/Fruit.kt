package com.fruit.buy.business

/**
 * 水果的设定
 * 成熟度由糖分成熟度和颜色成熟度组成，糖分成熟度必须要付款后才能拿到
 */
// 类取代类型码
data class Fruit(val type: Int) {
    companion object {
        const val TYPE_WATERMELON = 0
        const val TYPE_APPLE = 1
        const val TYPE_BANANA = 2
    }
    // 数据不应该被任意修改
    var weight: Int = 0
    // 描述数据的关联关系
    // 数据泥团
    var sugarRipeness = 0.0
    var colorRipeness = 0.0

    // 计算最终成熟度
    fun getRipeness(): Double = (sugarRipeness + colorRipeness) / 2f

//    class Builder(val type: Int) {
//        private var weight: Int = 0
//        var sugarRipeness = 0.0
//        var colorRipeness = 0.0
//        fun setWeight(weight: Int): Builder = this.apply { this.weight = weight }
//        fun setSugarRipeness(sugarRipeness: Double): Builder = this.apply { this.sugarRipeness = sugarRipeness }
//        fun setColorRipeness(colorRipeness: Double): Builder = this.apply { this.colorRipeness = colorRipeness }
//
//        fun build(): Fruit = Fruit(this)
//    }
}