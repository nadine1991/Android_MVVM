package com.anushka.bindingdemo1.model.breed


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "One Breed")

data class OneBreedItem(
    @SerializedName("breeds")
    val breeds: List<Breed>,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)