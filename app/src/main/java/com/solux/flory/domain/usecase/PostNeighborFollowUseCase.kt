package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.NeighborRepository
import javax.inject.Inject

class PostNeighborFollowUseCase @Inject constructor(
    private val neighborRepository: NeighborRepository
) {
    suspend operator fun invoke(nickname: String) =
        neighborRepository.postNeighborFollow(nickname)
}