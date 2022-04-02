package com.ramiroc.periodictable.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramiroc.periodictable.api.ElementFetcher
import com.ramiroc.periodictable.api.ElementService
import com.ramiroc.periodictable.data.model.Element
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ElementViewModel: ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<Element>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Element>> {
        return liveDataList
    }

    fun makeAPICall(){
        Log.i("start of call", "about to call")
        val retroInstance = ElementFetcher.getElementFetcher()
        val service = retroInstance.create(ElementService::class.java)
        val call = service.getAllElements()


        call.enqueue(object : retrofit2.Callback<List<Element>> {
            override fun onFailure(call: Call<List<Element>>, t: Throwable){
                Log.i("On Failure", t.message.toString())
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<List<Element>>, response: Response<List<Element>>) {
                Log.i("On Response", response.body().toString())
                liveDataList.postValue(response.body())
            }
        })
    }
}