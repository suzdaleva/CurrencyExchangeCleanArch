package com.myapp.currencyexchangecleanarch.common

import com.myapp.currencyexchangecleanarch.presentation.pager.TabItem

object Constants {
    const val BASE_URL = "https://api.privatbank.ua/"
    val tabs = listOf(
        TabItem.CashTab,
        TabItem.CashlessTab
    )
}