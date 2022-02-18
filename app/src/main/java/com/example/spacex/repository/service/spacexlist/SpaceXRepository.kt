package com.example.spacex.repository.service.spacexlist

import com.example.core.base.BaseRepository
import com.example.core.base.CacheManager
import com.example.spacex.repository.service.spacexlist.reqres.RocketAllListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

interface SpaceXRepository {
    fun getRocketList(): Flow<List<RocketAllListItem>>
}

class SpaceXRepositoryImpl @Inject constructor(
    private val service: SpaceXListService,
    val cacheManager: CacheManager
) : BaseRepository(), SpaceXRepository {

    override fun getRocketList() = sendRequest {
        service.getRocketList()
    }.catch { t->
        t.message
    }
}
