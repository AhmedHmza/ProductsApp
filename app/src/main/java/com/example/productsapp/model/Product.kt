package com.example.productsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Product  (
    @PrimaryKey
    val id : Int,
    val title : String,
    val price : Double,
    val description : String,
    val category : String,
    val image : String,
    val rating : Rating,
    var quantity: Int = 0
) : java.io.Serializable {

}
