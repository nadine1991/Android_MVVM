package com.anushka.bindingdemo1.model.breed


import com.google.gson.annotations.SerializedName

data class Weight(
    @SerializedName("imperial")
    val imperial: String,
    @SerializedName("metric")
    val metric: String
)