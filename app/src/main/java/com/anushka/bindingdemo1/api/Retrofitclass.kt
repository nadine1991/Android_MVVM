package com.anushka.bindingdemo1.api

import com.google.gson.GsonBuilder
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Retrofitclass {

    companion object{
        var client: OkHttpClient = OkHttpClient.Builder()
            .followRedirects(false)
            .followSslRedirects(false)
            .build()
        val BaseURL = "https://api.thedogapi.com/"
            fun getRetroInstance(): Retrofit {
                val gson = GsonBuilder()
                    .setLenient()
                    .create()

                return Retrofit.Builder()
                    .client(client)
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

            }
    }
}