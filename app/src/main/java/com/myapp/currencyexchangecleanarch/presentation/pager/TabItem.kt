package com.myapp.currencyexchangecleanarch.presentation.pager

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.myapp.currencyexchangecleanarch.presentation.cash.CashListScreen
import com.myapp.currencyexchangecleanarch.presentation.cashless.CashlessListScreen

sealed class TabItem(
    val index:Int,
    val icon: ImageVector?,
    val title: String,
    val screenToLoad: @Composable () -> Unit
) {
    object CashTab : TabItem(0, null, "Cash", {
        CashListScreen()
    })
    object CashlessTab : TabItem(1, null, "Cashless", {
        CashlessListScreen()
    })
}
