package com.onuremren.googleyemekapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onuremren.googleyemekapp.model.MenuItem
import com.onuremren.googleyemekapp.model.ShoppingList
import java.util.concurrent.locks.Lock


@Database(entities = [ShoppingList::class], version = 1)
abstract class FoodDatabase: RoomDatabase() {
    abstract fun shoppingDao(): FoodDao

}