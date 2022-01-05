package com.myapp.currencyexchangecleanarch.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.myapp.currencyexchangecleanarch.domain.model.Cashless

data class CashlessDto(
    @SerializedName("base_ccy")
    val baseCcy: String,
    val buy: String,
    val ccy: String,
    val sale: String
)

fun CashlessDto.toCashless(): Cashless {
    return Cashless(
        baseCcy = baseCcy,
        buy = buy,
        sale= sale,
        ccy = ccy
    )
}