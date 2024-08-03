package com.solux.flory.presentation.searchNeighbor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.entity.NeighborSearchEntity
import com.solux.flory.domain.repository.NeighborRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchNeighborViewModel @Inject constructor(
    private val neighborRepository: NeighborRepository
) : ViewModel() {
    private val _getNeighborSearchState =
        MutableStateFlow<UiState<List<NeighborSearchEntity>?>>(UiState.Empty)
    val getNeighborSearchState: StateFlow<UiState<List<NeighborSearchEntity>?>> =
        _getNeighborSearchState

    private val _postNeighborFollowState = MutableStateFlow<UiState<String>>(UiState.Empty)
    val postNeighborFollowState: StateFlow<UiState<String>> = _postNeighborFollowState

    fun getNeighborSearch(nickname: String) = viewModelScope.launch {
        _getNeighborSearchState.emit(UiState.Loading)
        neighborRepository.getNeighborSearch(nickname).fold(
            {
                if (it != null) {
                    _getNeighborSearchState.value = UiState.Success(it)
                } else _getNeighborSearchState.value = UiState.Failure("400")
            },
            { _getNeighborSearchState.value = UiState.Failure(it.message.toString()) }
        )
    }

    fun postNeighborFollow(nickname: String) = viewModelScope.launch {
        _postNeighborFollowState.emit(UiState.Loading)
        neighborRepository.postNeighborFollow(nickname).fold(
            { _postNeighborFollowState.value = UiState.Success(it) },
            { _postNeighborFollowState.value = UiState.Failure(it.message.toString()) }
        )
    }
}