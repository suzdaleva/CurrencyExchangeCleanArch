package com.myapp.currencyexchangecleanarch


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.google.accompanist.pager.*
import com.myapp.currencyexchangecleanarch.presentation.pager.TabLayout


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabLayout()
        }
    }
}

