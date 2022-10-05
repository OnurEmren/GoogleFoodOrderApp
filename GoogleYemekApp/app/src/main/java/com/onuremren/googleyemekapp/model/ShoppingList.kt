package com.onuremren.googleyemekapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ShoppingList(
    @ColumnInfo(name = "shoppingList")
    var shoppingList: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}