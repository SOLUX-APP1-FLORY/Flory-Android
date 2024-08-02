package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.NeighborDataSource
import com.solux.flory.data.dto.request.RequestNeighborFollowDto
import com.solux.flory.data.mapper.toNeighborSearchEntity
import com.solux.flory.domain.entity.NeighborSearchEntity
import com.solux.flory.domain.repository.NeighborRepository
import javax.inject.Inject

class NeighborRepositoryImpl @Inject constructor(
    private val neighborDataSource: NeighborDataSource
) : NeighborRepository {
    override suspend fun getNeighborInfo(): Result<List<String>> {
        return runCatching {
            neighborDataSource.getNeighborInfo().result ?: emptyList()
        }
    }

    override suspend fun getNeighborSearch(nickname: String): Result<List<NeighborSearchEntity>?> {
        return runCatching {
            neighborDataSource.getNeighborSearch(nickname).result?.map { it.toNeighborSearchEntity() }
        }
    }

    override suspend fun postNeighborFollow(nickname: String): Result<String> {
        return runCatching {
            neighborDataSource.postNeighborFollow(RequestNeighborFollowDto(nickname)).result ?: ""
        }
    }

    override suspend fun patchNeighborUnfollow(targetUserNickname: String): Result<String> {
        return runCatching {
            neighborDataSource.patchNeighborUnfollow(RequestNeighborFollowDto(targetUserNickname)).result ?: ""
        }
    }
}
