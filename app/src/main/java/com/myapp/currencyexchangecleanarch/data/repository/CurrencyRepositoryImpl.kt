package com.myapp.currencyexchangecleanarch.data.repository

import com.myapp.currencyexchangecleanarch.data.remote.dto.CashDto
import com.myapp.currencyexchangecleanarch.data.remote.dto.CashlessDto
import com.myapp.currencyexchangecleanarch.data.remote.CurrencyApi
import com.myapp.currencyexchangecleanarch.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val  api: CurrencyApi
) : CurrencyRepository{
    override suspend fun getCash(): List<CashDto> {
        return api.getCash()
    }

    override suspend fun getCashless(): List<CashlessDto> {
        return api.getCashless()
    }
}