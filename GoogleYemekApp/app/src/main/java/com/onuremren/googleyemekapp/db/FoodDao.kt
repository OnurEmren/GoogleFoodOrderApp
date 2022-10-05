package com.onuremren.googleyemekapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.onuremren.googleyemekapp.model.MenuItem
import com.onuremren.googleyemekapp.model.ShoppingList
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable


@Dao
interface FoodDao {

    @Query("SELECT shoppingList,id FROM shoppinglist")
    fun getListWithNameAndId(): Flowable<List<ShoppingList>>

    @Query("SELECT * FROM shoppinglist WHERE id = :id")
    fun getListById(id: Int): Flowable<ShoppingList>

    @Insert
    fun insert(shoppingList: ShoppingList): Completable

    @Delete
    fun delete(shoppingList: ShoppingList): Completable

    @Query("SELECT * FROM ShoppingList")
        fun observeOrder(): LiveData<List<ShoppingList>>


}