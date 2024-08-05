package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.NeighborRepository
import javax.inject.Inject

class GetNeighborSearchUseCase @Inject constructor(
    private val neighborRepository: NeighborRepository
){
    suspend operator fun invoke(nickname: String) = neighborRepository.getNeighborSearch(nickname)
}