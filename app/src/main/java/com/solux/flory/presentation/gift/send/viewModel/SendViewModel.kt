package com.solux.flory.presentation.gift.send.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solux.flory.presentation.gift.send.BouquetInfo

class SendViewModel: ViewModel() {
    var _message = MutableLiveData<String>("")
    val message: LiveData<String> get() = _message

    var _bouquetInfo = MutableLiveData<BouquetInfo>()
    val bouquetInfo: LiveData<BouquetInfo> get() = _bouquetInfo

    var _cardColor = MutableLiveData<String>("")
    val cardColor: LiveData<String> get() = _cardColor

    fun setMessage(message: String) {
        _message.value = message
    }

    fun setBouquetInfo(bouquet: BouquetInfo) {
        _bouquetInfo.value = bouquet
    }

    fun setCardColor(color: String) {
        _cardColor.value = color
    }
}