package com.onuremren.googleyemekapp.model

import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.onuremren.googleyemekapp.data.DataSource
import com.onuremren.googleyemekapp.repo.DaoRepository
import kotlinx.coroutines.launch
import java.text.NumberFormat
import kotlin.coroutines.coroutineContext

class OrderViewModel(): ViewModel() {
    val tuesdayMenuItem = DataSource.menuItems

    private var previousMainCoursePrice = 0.0
    private var previousSidePrice = 0.0
    private var previousAccompanimentPrice = 0.0
    private var adet = 1
    private var sideAdet = 1
    private var garniturAdet = 1


    val _setOneMain : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setThreeMain : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setFourMain: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setTwoMain: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setSide: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setSide2: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setSide3: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setSide4: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val _setGar: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setGar2: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setGar3: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val _setGar4: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private val _mainCourse = MutableLiveData<MenuItem?>()
    val mainCourse : LiveData<MenuItem?> = _mainCourse


    private val _side = MutableLiveData<MenuItem?>()
    val side : LiveData<MenuItem?> = _side

    private val _accompaniment = MutableLiveData<MenuItem?>()
    val accompaniment : LiveData<MenuItem?> = _accompaniment

    private var _subTotal = MutableLiveData(0.0)
    val subtotal : LiveData<String> = Transformations.map(_subTotal){
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _total = MutableLiveData(0.0)
    val total : LiveData<String> = Transformations.map(_total){
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _tax = MutableLiveData(0.0)
    val tax : LiveData<String> = Transformations.map(_tax){
        NumberFormat.getCurrencyInstance().format(it)

    }
    private val taxRate = 0.08


    fun setEntree(entree: String) {

        if (_mainCourse.value != null){
            previousMainCoursePrice = _mainCourse.value!!.price

        }

        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.minus(previousMainCoursePrice)

        }

        _mainCourse.value = tuesdayMenuItem.get(entree)

        updateSubtotal(_mainCourse.value!!.price)


    }


    fun setSide(side: String) {
        if (_side.value != null){
            previousSidePrice = _side.value!!.price
        }

        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.minus(previousSidePrice
            )
        }


        _side.value = tuesdayMenuItem.get(side)
        updateSubtotal(_side.value!!.price)
    }

    /**
     * Set the accompaniment for the order.
     */
    fun setAccompaniment(accompaniment: String) {

        if (_accompaniment.value != null){
            previousAccompanimentPrice = _accompaniment.value!!.price

        }

        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.minus(previousAccompanimentPrice)
        }

        _accompaniment.value = tuesdayMenuItem.get(accompaniment)
        updateSubtotal(_accompaniment.value!!.price)
    }

    /**
     * Update subtotal value.
     */
    private fun updateSubtotal(itemPrice: Double) {
        // TODO: if _subtotal.value is not null, update it to reflect the price of the recently
        //  added item.
        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.plus(itemPrice)
        } else{
            _subTotal.value = itemPrice
        }
        //  Otherwise, set _subtotal.value to equal the price of the item.

        // TODO: calculate the tax and resulting total
         calculateTaxAndTotal()
    }

    /**
     * Calculate tax and update total.
     */
    fun calculateTaxAndTotal() {
        // TODO: set _tax.value based on the subtotal and the tax rate.
        //_tax.value = (_subTotal.value)?.times(taxRate)
        // TODO: set the total based on the subtotal and _tax.value.
        if (_subTotal.value!! >= 40 && _subTotal.value!! < 55){
            _tax.value = (15.0)
        } else if (_subTotal.value!! >= 90 && _subTotal.value!! < 100){
            _tax.value = 30.0
        } else if (_subTotal.value !! >= 135 && _subTotal.value!! < 145){
            _tax.value = 45.0
        }

        _total.value = (_subTotal.value)?.minus(_tax.value!!)

    }

    fun indirimsizHesap(){
        _total.value = (_subTotal.value)
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        // TODO: Reset all values associated with an order
        previousMainCoursePrice = 0.0
        previousSidePrice = 0.0
        previousAccompanimentPrice = 0.0
        _mainCourse.value = null
        _side.value = null
        _accompaniment.value = null
        _subTotal.value = 0.0
        _total.value = 0.0
        _tax.value = 0.0
        adet = 1
    }

    fun resetSideOrder(){
        _side.value = null
        sideAdet = 1
        if (sideAdet == 1){
            _subTotal.value  = (_mainCourse.value!!.price).times(adet)
        } else{
        //    _subTotal.value = _side.value!!.price
        }
    }


    fun resetGarOrder(){
        _accompaniment.value = null
        garniturAdet = 1
        if (garniturAdet == 1 && _side.value != null){
            val araToplam = (_mainCourse.value!!.price).times(adet)
            val sideAraToplam = (_side.value!!.price).times(sideAdet)
            val toplam = araToplam.plus(sideAraToplam)

            _subTotal.value = toplam
        }
        else{
          //  _subTotal.value = _accompaniment.value!!.price
        }

    }

    fun setSide(){
        sideAdet += 1
        _setSide.value = sideAdet
        updateSubtotal(_side.value!!.price)
    }

    fun setSide2(){
        sideAdet += 1
        _setSide2.value = sideAdet
        updateSubtotal(_side.value!!.price)
    }
    fun minusSetSide2(){
        sideAdet -= 1
        _setSide2.value = sideAdet
        updateMinusSubtotal(_side.value!!.price)
    }
    fun setSide3( ){
        sideAdet += 1
        _setSide3.value = sideAdet
        updateSubtotal(_side.value!!.price)
    }
    fun minusSetSide3(){
        sideAdet -= 1
        _setSide3.value = sideAdet
        updateMinusSubtotal(_side.value!!.price)
    }

    fun setSide4(){
        sideAdet += 1
        _setSide4.value = sideAdet
        updateSubtotal(_side.value!!.price)
    }

    fun minusSetSide4(){
        sideAdet -= 1
        _setSide4.value = sideAdet
        updateMinusSubtotal(_side.value!!.price)
    }

    fun minusSide(){
        sideAdet -= 1
        _setSide.value = sideAdet
        updateMinusSubtotal(_side.value!!.price)
    }

    fun setGar(){
        garniturAdet += 1
        _setGar.value = garniturAdet
        updateSubtotal(_accompaniment.value!!.price)
    }

    fun minusGar(){
        garniturAdet -= 1
        _setGar.value = garniturAdet
        updateMinusSubtotal(_accompaniment.value!!.price)
    }

    fun setGar2(){
        garniturAdet += 1
        _setGar2.value = garniturAdet
        updateSubtotal(_accompaniment.value!!.price)
    }

    fun minusGar2(){
        garniturAdet -= 1
        _setGar2.value = garniturAdet
        updateMinusSubtotal(_accompaniment.value!!.price)
    }
    fun setGar3(){
        garniturAdet += 1
        _setGar3.value = garniturAdet
        updateSubtotal(_accompaniment.value!!.price)
    }
    fun minusGar3(){
        garniturAdet -= 1
        _setGar3.value = garniturAdet
        updateMinusSubtotal(_accompaniment.value!!.price)
    }
    fun setGar4(){
        garniturAdet += 1
        _setGar4.value = garniturAdet
        updateSubtotal(_accompaniment.value!!.price)
    }
    fun minusGar4(){
        garniturAdet -= 1
        _setGar4.value = garniturAdet
        updateMinusSubtotal(_accompaniment.value!!.price)
    }


    fun plusOne(){
        adet += 1
        _setOneMain.value = adet
        updateSubtotal(_mainCourse.value!!.price)
    }

    fun plusTwo(){
        adet += 1
        _setTwoMain.value = adet
        updateSubtotal(_mainCourse.value!!.price)

    }
    fun minusTwo(){
        adet -= 1
        _setTwoMain.value = adet
        updateMinusSubtotal(_mainCourse.value!!.price)

    }

    fun plusThreeMain(){
        adet += 1
        _setThreeMain.value = adet
        updateSubtotal(_mainCourse.value!!.price)

    }
    fun plusFourMain(){
        adet += 1
        _setFourMain.value = adet
        updateSubtotal(_mainCourse.value!!.price)

    }
    fun minusFourMain(){
        adet -= 1
        _setFourMain.value = adet
        updateMinusSubtotal(_mainCourse.value!!.price)
    }

    fun minusThree(){
        adet -= 1
        _setThreeMain.value = adet
        updateMinusSubtotal(_mainCourse.value!!.price)
    }

    fun minusOneMain(){
        adet -= 1
        _setOneMain.value = adet
        updateMinusSubtotal(_mainCourse.value!!.price)
    }

//    fun deleteOrder(shoppingList: ShoppingList) = viewModelScope.launch {
//        repository.deleteData(shoppingList)
//    }

    private fun updateMinusSubtotal(itemPrice: Double) {
        // TODO: if _subtotal.value is not null, update it to reflect the price of the recently
        //  added item.
        if (_subTotal.value != null){
            _subTotal.value = (_subTotal.value)?.minus(itemPrice)
        } else{
            _subTotal.value = itemPrice
        }
        //  Otherwise, set _subtotal.value to equal the price of the item.

        // TODO: calculate the tax and resulting total

        calculateTaxAndTotal()
    }

}