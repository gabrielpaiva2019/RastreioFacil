package com.rastreiofacil.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    companion object {
        fun getBarbeiroServiceInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.aftership.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}