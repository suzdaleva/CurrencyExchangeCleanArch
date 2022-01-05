package com.myapp.currencyexchangecleanarch.presentation.pager

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.myapp.currencyexchangecleanarch.common.Constants

@ExperimentalPagerApi
@Composable
fun TabPage(pagerState: PagerState, tabItems: List<TabItem>) {
    HorizontalPager(
        count = Constants.tabs.size,
        state = pagerState
    ) { index ->
        tabItems[index].screenToLoad()
    }
}
