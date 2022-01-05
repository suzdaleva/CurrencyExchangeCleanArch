package com.myapp.currencyexchangecleanarch.presentation.cash.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.myapp.currencyexchangecleanarch.domain.model.Cash

@Composable
fun CashListItem(cash: Cash){
   Row(
       modifier = Modifier.padding(20.dp).height(IntrinsicSize.Min),
       horizontalArrangement = Arrangement.SpaceBetween
   ){
       Column(modifier = Modifier,
       verticalArrangement = Arrangement.Center) {
           Text(
               //color = MaterialTheme.colors.background,
               text = "Name",
               style = MaterialTheme.typography.h4
           )
           Spacer(modifier = Modifier.height(4.dp))
           Text(
               text = "Buy",
               style = MaterialTheme.typography.h4
           )
           Spacer(modifier = Modifier.height(4.dp))
           Text(
               text = "Sale",
               style = MaterialTheme.typography.h4
           )
       }
       Spacer(modifier = Modifier.width(20.dp))
       Divider(
           color = MaterialTheme.colors.onBackground,
           modifier = Modifier
               .fillMaxHeight()
               .width(1.dp)
       )
       Spacer(modifier = Modifier.width(20.dp))
       Column(modifier = Modifier,
           verticalArrangement = Arrangement.SpaceBetween,
       horizontalAlignment = Alignment.Start) {
           Text(
               text = cash.ccy,
               style = MaterialTheme.typography.h4,

           )
           Spacer(modifier = Modifier.height(4.dp))
           Text(
               text = cash.buy,
               style = MaterialTheme.typography.h4,

           )
           Spacer(modifier = Modifier.height(4.dp))
           Text(
               text = cash.sale,
               style = MaterialTheme.typography.h4,
           )
       }
   }
}