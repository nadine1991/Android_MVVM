package com.anushka.bindingdemo1.model.breed


import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("bred_for")
    val bredFor: String,
    @SerializedName("breed_group")
    val breedGroup: String,

    @SerializedName("id")
    val id: Int,
    @SerializedName("life_span")
    val lifeSpan: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("reference_image_id")
    val referenceImageId: String,
    @SerializedName("temperament")
    val temperament: String,
    @SerializedName("weight")
    val weight: Weight
)