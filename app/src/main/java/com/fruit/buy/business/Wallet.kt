package com.fruit.buy.business

import android.util.Log

class Wallet {
    private var money = 1000.0

    fun pay(money: Double): Double {
        Log.e(Constants.TAG, "支付 $money")
        this.money -= money
        if (this.money < 0) throw RuntimeException("money < 0")
        return money
    }
}