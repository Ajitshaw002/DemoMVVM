package com.example.demoviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit





class HeroesViewModel : ViewModel() {
    var heroList:MutableLiveData<List<Hero>>?=null

    //we will call this method to get the data
    fun getHeroes(): LiveData<List<Hero>> {
        //if the list is null
        if (heroList == null) {
            heroList = MutableLiveData<List<Hero>>()
            //we will load it asynchronously from server in this method
            loadHeroes()
        }

        //finally we will return the list
        return heroList as MutableLiveData<List<Hero>>
    }

    //This method is using Retrofit to get the JSON data from URL
    private fun loadHeroes() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val call = api.heroes


        call.enqueue(object : Callback<List<Hero>> {

            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {

                //finally we are setting the list to our MutableLiveData
                heroList?.setValue(response.body())
            }

           override fun onFailure(call: Call<List<Hero>>, t: Throwable) {

            }
        })
    }
}