package com.ramiroc.periodictable.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ElementFetcher {

    companion object{
        val BASE_URL = "https://periodic-table-elements-info.herokuapp.com/"

        fun getElementFetcher(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        }
    }
}