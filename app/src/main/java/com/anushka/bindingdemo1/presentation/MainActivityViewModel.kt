package com.anushka.bindingdemo1.presentation

import androidx.lifecycle.*
import com.anushka.bindingdemo1.api.HTTPService
import com.anushka.bindingdemo1.api.Retrofitclass
import com.anushka.bindingdemo1.model.breadlist.BreedList
import com.anushka.bindingdemo1.model.breadlist.BreedListItem
import com.anushka.bindingdemo1.model.breed.OneBreed
import com.anushka.bindingdemo1.model.gridbreed.breedgrid

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityViewModel: ViewModel() {




    var selectdatalist= MutableLiveData<BreedList>()
    var showdatalist= MutableLiveData<OneBreed>()



    fun getdataselectobserver():MutableLiveData<BreedList>{

        return selectdatalist

    }



    fun getdatashowobserver():MutableLiveData<OneBreed>{

        return showdatalist

    }

    fun makeApiCall(){

        viewModelScope.launch(Dispatchers.IO){

                val retroinstance = Retrofitclass.getRetroInstance().create(HTTPService::class.java)
                val response = retroinstance.getbreeds()
                println("responce"+ response)

               selectdatalist.postValue(response)

        }
    }


    fun makeapiimageCall(id:String){


        viewModelScope.launch(Dispatchers.IO){

            val retroinstance = Retrofitclass.getRetroInstance().create(HTTPService::class.java)
            val response = retroinstance.getbreed(id)
            println("responce image clicked"+ response)

            showdatalist.postValue(response)

        }

    }



    }

