package com.myapp.currencyexchangecleanarch.presentation.cash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.currencyexchangecleanarch.common.Resource
import com.myapp.currencyexchangecleanarch.domain.use_case.get_cash.GetCashUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CashListViewModel @Inject constructor(
    val getCashUseCase: GetCashUseCase
) : ViewModel(){
    private val _state = mutableStateOf(CashListState())
    val state: State<CashListState> = _state


    init {
        getCashMoney()
    }
    private fun getCashMoney() {
        getCashUseCase().onEach{
            result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CashListState(cashMoney = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CashListState(error = result.message ?: "Unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = CashListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}