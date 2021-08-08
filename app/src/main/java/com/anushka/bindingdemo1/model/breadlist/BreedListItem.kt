package com.anushka.bindingdemo1.model.breadlist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Breed_List_Item")

data class BreedListItem(

    @SerializedName("breed_group")
    val breedGroup: String,
    @SerializedName("description")
    val description: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("image")
    val image: Image,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("reference_image_id")
    val referenceImageId: String,

    )