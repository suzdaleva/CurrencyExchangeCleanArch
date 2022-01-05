package com.myapp.currencyexchangecleanarch.domain.use_case.get_cash

import com.myapp.currencyexchangecleanarch.common.Resource
import com.myapp.currencyexchangecleanarch.data.remote.dto.toCash
import com.myapp.currencyexchangecleanarch.domain.model.Cash
import com.myapp.currencyexchangecleanarch.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCashUseCase @Inject constructor(
    private val repository: CurrencyRepository
){
    operator fun invoke() : Flow<Resource<List<Cash>>> = flow {
        try {
            emit(Resource.Loading<List<Cash>>())
            val cashMoney = repository.getCash().map{it.toCash()}
            emit(Resource.Success<List<Cash>>(cashMoney))
        }
        catch(e: HttpException) {
            emit(Resource.Error<List<Cash>>(e.localizedMessage ?: "Unexpected error"))
        }
        catch(e: IOException) {
            emit(Resource.Error<List<Cash>>( "Server connection error"))
        }
    }
}