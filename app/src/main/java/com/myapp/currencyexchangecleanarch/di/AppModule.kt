package com.myapp.currencyexchangecleanarch.di

import android.provider.SyncStateContract
import com.myapp.currencyexchangecleanarch.common.Constants
import com.myapp.currencyexchangecleanarch.data.remote.CurrencyApi
import com.myapp.currencyexchangecleanarch.data.repository.CurrencyRepositoryImpl
import com.myapp.currencyexchangecleanarch.domain.repository.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCurrencyApi() : CurrencyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCurrencyRepository(api: CurrencyApi) : CurrencyRepository {
        return CurrencyRepositoryImpl(api)
    }
}