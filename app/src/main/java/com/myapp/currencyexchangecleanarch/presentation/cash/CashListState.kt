package com.myapp.currencyexchangecleanarch.presentation.cash

import com.myapp.currencyexchangecleanarch.domain.model.Cash

data class CashListState (
    val isLoading: Boolean = false,
    val cashMoney: List<Cash> = emptyList(),
    val error: String = ""
)