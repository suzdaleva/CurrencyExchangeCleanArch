package com.myapp.currencyexchangecleanarch.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.myapp.currencyexchangecleanarch.domain.model.Cash

data class CashDto(
    @SerializedName("base_ccy")
    val baseCcy: String,
    val buy: String,
    val ccy: String,
    val sale: String
)

fun CashDto.toCash(): Cash {
    return Cash(
        baseCcy = baseCcy,
        buy = buy,
        sale= sale,
        ccy = ccy
    )
}