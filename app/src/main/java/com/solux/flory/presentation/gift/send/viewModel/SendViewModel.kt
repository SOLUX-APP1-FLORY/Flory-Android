package com.solux.flory.presentation.gift.send.viewModel

import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.R
import com.solux.flory.domain.repository.LetterRepository
import com.solux.flory.presentation.gift.send.BouquetInfo
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SendViewModel @Inject constructor(
    private val letterRepository: LetterRepository
) : ViewModel() {
    var _message = MutableLiveData<String>("")
    val message: LiveData<String> get() = _message

    var _bouquetInfo = MutableLiveData<BouquetInfo>()
    val bouquetInfo: LiveData<BouquetInfo> get() = _bouquetInfo

    var _cardColor = MutableLiveData<String>("")
    val cardColor: LiveData<String> get() = _cardColor

    var _selectedImageView = MutableLiveData<ImageView>()
    val selectedImageView: LiveData<ImageView> get() = _selectedImageView

    private val _postLetterState = MutableStateFlow<UiState<String>>(UiState.Empty)
    val postLetterState: StateFlow<UiState<String>> = _postLetterState

    fun postLetter(flowerName: String, receiverNickname: String, content: String) =
        viewModelScope.launch {
            _postLetterState.value = UiState.Loading
            letterRepository.postLetter(flowerName, receiverNickname, content).fold(
                {
                    if (it != null) _postLetterState.value =
                        UiState.Success(it) else _postLetterState.value = UiState.Failure("400")
                },
                { _postLetterState.value = UiState.Failure(it.message.toString()) }
            )
        }


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