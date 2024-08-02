package com.solux.flory.presentation.gift.send

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.repository.NeighborRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectNeighborViewModel @Inject constructor(
    private val neighborRepository: NeighborRepository
) : ViewModel() {
    private val _getNeighborInfoState = MutableStateFlow<UiState<List<String>>>(UiState.Empty)
    val getNeighborInfoState: StateFlow<UiState<List<String>>> = _getNeighborInfoState

    init {
        getNeighborInfo()
    }

    private fun getNeighborInfo() = viewModelScope.launch {
        _getNeighborInfoState.emit(UiState.Loading)
        neighborRepository.getNeighborInfo().fold(
            {
                _getNeighborInfoState.emit(UiState.Success(it))
            },
            { _getNeighborInfoState.emit(UiState.Failure(it.message.toString())) }
        )
    }
}