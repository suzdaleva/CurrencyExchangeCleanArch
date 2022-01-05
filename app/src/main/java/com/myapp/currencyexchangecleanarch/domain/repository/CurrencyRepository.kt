package com.myapp.currencyexchangecleanarch.domain.repository

import com.myapp.currencyexchangecleanarch.data.remote.dto.CashDto
import com.myapp.currencyexchangecleanarch.data.remote.dto.CashlessDto
import retrofit2.http.GET

interface CurrencyRepository {
    suspend fun getCash() : List<CashDto>
    suspend fun getCashless() : List<CashlessDto>
}