package com.ramiroc.periodictable.api

import com.ramiroc.periodictable.data.model.Element
import retrofit2.Call
import retrofit2.http.GET

interface ElementService {

    @GET("elements")
    fun getAllElements(): Call<List<Element>>
}