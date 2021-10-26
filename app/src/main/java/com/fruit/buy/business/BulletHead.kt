package com.fruit.buy.business

import kotlin.random.Random

data class BulletHead(val factor: Int) {
    companion object {
        fun generate() = BulletHead(Random.nextInt())
    }
}