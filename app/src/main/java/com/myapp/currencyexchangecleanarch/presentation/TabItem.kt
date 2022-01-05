package com.myapp.currencyexchangecleanarch.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.myapp.currencyexchangecleanarch.presentation.cash.CashListScreen
import com.myapp.currencyexchangecleanarch.presentation.cashless.CashlessListScreen

sealed class TabItem(
    val index:Int,
    val icon: ImageVector,
    val title: String,
    val screenToLoad: @Composable () -> Unit
) {
    object CashTab : TabItem(0, Icons.Default.Home, "Cash", {
        CashListScreen()
    })
    object CashlessTab : TabItem(1, Icons.Default.Home, "Cashless", {
        CashlessListScreen()
    })
}
