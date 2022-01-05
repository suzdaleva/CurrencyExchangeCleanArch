package com.myapp.currencyexchangecleanarch.presentation.cashless

import com.myapp.currencyexchangecleanarch.domain.model.Cashless

data class CashlessListState (
    val isLoading: Boolean = false,
    val cashlessMoney: List<Cashless> = emptyList(),
    val error: String = ""
)