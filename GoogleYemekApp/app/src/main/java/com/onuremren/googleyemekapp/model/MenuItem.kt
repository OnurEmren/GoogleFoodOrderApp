package com.onuremren.googleyemekapp.model

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat


@Entity
data class MenuItem(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "price")
    var price: Double,

    @ColumnInfo(name = "type")
    val type: Int

) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}