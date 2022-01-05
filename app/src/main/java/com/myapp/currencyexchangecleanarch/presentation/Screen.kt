package com.myapp.currencyexchangecleanarch.presentation

sealed class Screen(val route: String) {
    object CashListScreen: Screen("cash_list_screen")
    object CashlessListScreen: Screen("cashless_list_screen")
}