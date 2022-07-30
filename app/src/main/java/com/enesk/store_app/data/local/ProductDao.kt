package com.enesk.store_app.data.local

import androidx.room.*
import com.enesk.store_app.data.local.entity.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products : ArrayList<Product>)

    @Delete
    suspend fun delete(product: Product)

    //flow zaten asenkron calıstıgı için suspend yazmamıza gerek yok
    @Query("SELECT * FROM products")
    fun observeProducts(): Flow<List<Product>>

}