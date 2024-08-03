package com.solux.flory.presentation.gift.confirm
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.entity.BouquetDetailEntity
import com.solux.flory.domain.entity.BouquetInfoEntity
import com.solux.flory.domain.repository.BouquetRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PresentViewModel @Inject constructor(
    private val bouquetRepository: BouquetRepository,
) : ViewModel(){
    private val _getBouquetState = MutableStateFlow<UiState<List<BouquetInfoEntity>>>(UiState.Empty)
    val getBouquetState: StateFlow<UiState<List<BouquetInfoEntity>>> = _getBouquetState

    private val _getBouquetDetailState = MutableStateFlow<UiState<BouquetDetailEntity>>(UiState.Empty)
    val getBouquetDetailState: StateFlow<UiState<BouquetDetailEntity>> = _getBouquetDetailState

    init{
        getBouquetInfo()
    }

    fun getBouquetInfo() = viewModelScope.launch {
        _getBouquetState.emit(UiState.Loading)
        bouquetRepository.getBouquetInfo().fold(
            {
                if (it != null) _getBouquetState.emit(UiState.Success(it)) else _getBouquetState.emit(
                    UiState.Failure("400")
                )
            },
            { _getBouquetState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun getBouquetDetail(giftId: Int) = viewModelScope.launch {
        _getBouquetDetailState.emit(UiState.Loading)
        bouquetRepository.getBouquetDetail(giftId).fold(
            {
                if (it != null) _getBouquetDetailState.emit(UiState.Success(it)) else _getBouquetDetailState.emit(
                    UiState.Failure("400")
                )
            },
            { _getBouquetDetailState.emit(UiState.Failure(it.message.toString())) }
        )
    }
}
