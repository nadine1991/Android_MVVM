package com.anushka.bindingdemo1.api

import com.anushka.bindingdemo1.model.breadlist.BreedList
import com.anushka.bindingdemo1.model.breadlist.BreedListItem
import com.anushka.bindingdemo1.model.breed.OneBreed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface HTTPService {

    @GET("/v1/breeds")
    suspend fun getbreeds(): BreedList

    @GET("/v1/images/search")
    suspend fun getbreed(@Query("breed_id")id:String):OneBreed

}