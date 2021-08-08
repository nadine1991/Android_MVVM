package com.anushka.bindingdemo1.model.breadlist

class BreedListSelect(
    val  breedGroup: String,
    val description:String,
    val id: String,
    val image: String,
    val name: String,
    val origin: String,
    val referenceImageId: String,

) {
    // property (data member)

   override  fun toString(): String {
        return this.name
    }
}


