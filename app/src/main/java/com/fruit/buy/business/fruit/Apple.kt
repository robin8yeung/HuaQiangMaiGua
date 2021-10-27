package com.fruit.buy.business.fruit

class Apple(builder: Builder): Fruit(builder) {
    override fun getUnitPrice(): Int = 5

    override fun getDiscount(): Double = ripeness.colorRipeness

    class Builder: Fruit.Builder() {
        override fun build(): Fruit = Apple(this)
    }
}