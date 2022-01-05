package com.myapp.currencyexchangecleanarch.data.remote

import com.myapp.currencyexchangecleanarch.data.remote.dto.CashDto
import com.myapp.currencyexchangecleanarch.data.remote.dto.CashlessDto
import retrofit2.http.GET

interface CurrencyApi {

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getCash() : List<CashDto>

    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getCashless() : List<CashlessDto>
}