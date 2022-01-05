package com.myapp.currencyexchangecleanarch.presentation.cashless

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.currencyexchangecleanarch.common.Resource
import com.myapp.currencyexchangecleanarch.domain.use_case.get_cash.GetCashUseCase
import com.myapp.currencyexchangecleanarch.domain.use_case.get_cashless.GetCashlessUseCase
import com.myapp.currencyexchangecleanarch.presentation.cash.CashListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CashlessListViewModel @Inject constructor(
    val getCashlessUseCase: GetCashlessUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CashlessListState())
    val state: State<CashlessListState> = _state

    init {
        getCashlessMoney()
    }

    private fun getCashlessMoney() {
        getCashlessUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CashlessListState(cashlessMoney = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CashlessListState(error = result.message ?: "Unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = CashlessListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
