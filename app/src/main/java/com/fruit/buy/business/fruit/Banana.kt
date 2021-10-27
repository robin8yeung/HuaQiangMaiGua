package com.fruit.buy.business.fruit

class Banana(builder: Builder): Fruit(builder) {
    override fun getUnitPrice(): Int = 6

    override fun getDiscount(): Double = ripeness.colorRipeness * 0.8

    class Builder: Fruit.Builder() {
        override fun build(): Fruit = Banana(this)
    }
}