package com.onuremren.googleyemekapp.repo

import androidx.lifecycle.LiveData
import com.onuremren.googleyemekapp.db.FoodDao
import com.onuremren.googleyemekapp.model.ShoppingList

interface DaoRepositoryInterface {

    suspend fun deleteOrder(shoppingList: ShoppingList)
    fun orderList(): LiveData<List<ShoppingList>>

}