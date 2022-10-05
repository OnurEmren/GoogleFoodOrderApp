package com.onuremren.googleyemekapp.repo

import androidx.lifecycle.LiveData
import com.onuremren.googleyemekapp.db.FoodDao
import com.onuremren.googleyemekapp.model.ShoppingList

class DaoRepository (private val foodDao: FoodDao): DaoRepositoryInterface {
    override suspend fun deleteOrder(shoppingList: ShoppingList) {
        foodDao.delete(shoppingList)
    }

    override fun orderList(): LiveData<List<ShoppingList>> {
       return foodDao.observeOrder()
    }


}