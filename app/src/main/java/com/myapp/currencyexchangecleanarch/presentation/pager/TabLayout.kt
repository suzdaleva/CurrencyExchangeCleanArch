package com.myapp.currencyexchangecleanarch.presentation.pager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.myapp.currencyexchangecleanarch.common.Constants
import com.myapp.currencyexchangecleanarch.presentation.ui.theme.CurrencyExchangeCleanArchTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun TabLayout() {
    CurrencyExchangeCleanArchTheme(
        darkTheme = true,
    ) {
        val pagerState = rememberPagerState()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = {
                TabPage(tabItems = Constants.tabs, pagerState = pagerState)
            },
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                Column(content = {
                    IconWithTextTabLayout(
                        Constants.tabs,
                        selectedIndex = pagerState.currentPage,
                        onPageSelected = { tabItem: TabItem ->
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(tabItem.index)
                            }
                        })
                })
            },
        )
    }
}
