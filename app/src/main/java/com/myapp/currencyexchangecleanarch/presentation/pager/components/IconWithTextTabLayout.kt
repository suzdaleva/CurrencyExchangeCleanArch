package com.myapp.currencyexchangecleanarch.presentation.pager

import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.myapp.currencyexchangecleanarch.R

@ExperimentalPagerApi
@Composable
fun IconWithTextTabLayout(
    tabs: List<TabItem>,
    selectedIndex: Int,
    onPageSelected: ((tabItem: TabItem) -> Unit)
) {
    TabRow(selectedTabIndex = selectedIndex) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(selected = index == selectedIndex, onClick = {
                onPageSelected(tabItem)
            }, text = {
                Text(text = tabItem.title)
            }, icon = {
                when(tabItem) {
                    is TabItem.CashTab -> Icon(ImageVector.vectorResource(R.drawable.ic_baseline_attach_money_24), "")
                    is TabItem.CashlessTab -> Icon(ImageVector.vectorResource(R.drawable.ic_baseline_monetization_on_24), "")
                }
            })
        }
    }
}