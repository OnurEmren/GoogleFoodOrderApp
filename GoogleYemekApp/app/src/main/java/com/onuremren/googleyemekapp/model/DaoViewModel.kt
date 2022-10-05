package com.onuremren.googleyemekapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuremren.googleyemekapp.repo.DaoRepository
import com.onuremren.googleyemekapp.repo.DaoRepositoryInterface
import kotlinx.coroutines.launch

class DaoViewModel(private val repository: DaoRepositoryInterface): ViewModel() {

    val orderList = repository.orderList()


    fun deleteOrder(shoppingList: ShoppingList) = viewModelScope.launch {
        repository.deleteOrder(shoppingList)
    }

}