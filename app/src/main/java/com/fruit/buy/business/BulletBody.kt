package com.fruit.buy.business

import kotlin.random.Random

data class BulletBody(val factor: Int) {
    companion object {
        fun generate() = BulletBody(Random.nextInt())
    }
}