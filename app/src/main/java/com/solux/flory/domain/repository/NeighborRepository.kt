package com.solux.flory.domain.repository

interface NeighborRepository {
    suspend fun getNeighborInfo(): Result<List<String>?>
}