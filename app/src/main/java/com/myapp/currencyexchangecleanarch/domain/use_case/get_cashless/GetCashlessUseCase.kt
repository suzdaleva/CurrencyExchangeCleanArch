package com.myapp.currencyexchangecleanarch.domain.use_case.get_cashless

import com.myapp.currencyexchangecleanarch.common.Resource
import com.myapp.currencyexchangecleanarch.data.remote.dto.toCash
import com.myapp.currencyexchangecleanarch.data.remote.dto.toCashless
import com.myapp.currencyexchangecleanarch.domain.model.Cash
import com.myapp.currencyexchangecleanarch.domain.model.Cashless
import com.myapp.currencyexchangecleanarch.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCashlessUseCase @Inject constructor(
    private val repository: CurrencyRepository
){
    operator fun invoke() : Flow<Resource<List<Cashless>>> = flow {
        try {
            emit(Resource.Loading<List<Cashless>>())
            val cashlessMoney = repository.getCashless().map{it.toCashless()}
            emit(Resource.Success<List<Cashless>>(cashlessMoney))
        }
        catch(e: HttpException) {
            emit(Resource.Error<List<Cashless>>(e.localizedMessage ?: "Unexpected error"))
        }
        catch(e: IOException) {
            emit(Resource.Error<List<Cashless>>( "Server connection error"))
        }
    }
}