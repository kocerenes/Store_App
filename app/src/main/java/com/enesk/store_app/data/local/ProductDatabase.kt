package com.enesk.store_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enesk.store_app.data.local.entity.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}