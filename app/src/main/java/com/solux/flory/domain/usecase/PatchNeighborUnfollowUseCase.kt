package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.NeighborRepository
import javax.inject.Inject

class PatchNeighborUnfollowUseCase @Inject constructor(
    private val neighborRepository: NeighborRepository
) {
    suspend operator fun invoke(targetUserNickname: String) =
        neighborRepository.patchNeighborUnfollow(targetUserNickname)
}