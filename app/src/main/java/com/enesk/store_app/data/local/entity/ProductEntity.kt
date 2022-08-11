package com.enesk.store_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val category: String?,
    val description: String?,
    val image: String?,
    val price: String?,
    val title: String?
)