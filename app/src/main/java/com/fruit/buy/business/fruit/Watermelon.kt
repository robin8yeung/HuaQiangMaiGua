package com.fruit.buy.business.fruit

class Watermelon(builder: Builder): Fruit(builder) {
    override fun getUnitPrice(): Int = 7

    override fun getDiscount(): Double = ripeness.colorRipeness * 0.9

    class Builder: Fruit.Builder() {
        override fun build(): Fruit = Watermelon(this)
    }
}