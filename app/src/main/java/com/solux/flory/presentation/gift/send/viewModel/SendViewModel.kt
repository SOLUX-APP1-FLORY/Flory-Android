package com.solux.flory.presentation.gift.send.viewModel

import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solux.flory.R
import com.solux.flory.presentation.gift.send.BouquetInfo

class SendViewModel: ViewModel() {
    var _message = MutableLiveData<String>("")
    val message: LiveData<String> get() = _message

    var _bouquetInfo = MutableLiveData<BouquetInfo>()
    val bouquetInfo: LiveData<BouquetInfo> get() = _bouquetInfo

    var _cardColor = MutableLiveData<String>("")
    val cardColor: LiveData<String> get() = _cardColor

    var _selectedImageView = MutableLiveData<ImageView>()
    val selectedImageView: LiveData<ImageView> get() = _selectedImageView

    fun setMessage(message: String) {
        _message.value = message
    }

    fun setBouquetInfo(bouquet: BouquetInfo) {
        _bouquetInfo.value = bouquet
    }

    fun setCardColor(color: String) {
        _cardColor.value = color
    }

    private fun updateImageView(imageView: ImageView, isSelected: Boolean) {
        imageView.isSelected = isSelected
        val widthResId = if (isSelected) R.dimen.selected_width else R.dimen.unselected_width
        val heightResId = if (isSelected) R.dimen.selected_height else R.dimen.unselected_height
        val marginResId = if (isSelected) R.dimen.selected_margin else R.dimen.unselected_margin

        imageView.layoutParams.width = imageView.resources.getDimensionPixelSize(widthResId)
        imageView.layoutParams.height = imageView.resources.getDimensionPixelSize(heightResId)
        val marginLayoutParams = imageView.layoutParams as ViewGroup.MarginLayoutParams
        marginLayoutParams.topMargin = imageView.resources.getDimensionPixelSize(marginResId)
        imageView.requestLayout()
    }

    fun setImageView(currentImageView: ImageView) {
        _selectedImageView.value?.let { previousImageView ->
            updateImageView(previousImageView, false)
        }

        updateImageView(currentImageView, true)
        _selectedImageView.value = currentImageView
    }
}