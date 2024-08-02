package com.solux.flory.domain.repository

import com.solux.flory.domain.entity.NeighborSearchEntity

interface NeighborRepository {
    suspend fun getNeighborInfo(): Result<List<String>>
    suspend fun getNeighborSearch(nickname: String): Result<List<NeighborSearchEntity>?>
    suspend fun postNeighborFollow(nickname: String): Result<String>
    suspend fun patchNeighborUnfollow(nickname: String): Result<String>
}