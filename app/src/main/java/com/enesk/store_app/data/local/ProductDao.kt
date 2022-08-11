package com.enesk.store_app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.enesk.store_app.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productEntities: ArrayList<ProductEntity>)

    @Delete
    suspend fun delete(productEntity: ProductEntity)

    //flow zaten asenkron calıstıgı için suspend yazmamıza gerek yok
    @Query("SELECT * FROM products")
    fun observeProducts(): Flow<List<ProductEntity>>
}