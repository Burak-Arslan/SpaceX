package com.example.spacex.domain.spacexlist

import com.example.core.base.UseCase
import com.example.core.util.Mapper
import com.example.core.util.ResProvider
import com.example.spacex.data.RocketInfo
import com.example.spacex.repository.service.spacexlist.SpaceXRepository
import com.example.spacex.repository.service.spacexlist.reqres.RocketAllListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SpaceXListUseCase @Inject constructor(
    private val resProvider: ResProvider,
    private val repo: SpaceXRepository
) : UseCase<Unit, List<RocketInfo>>() {

    override fun execute(params: Unit): Flow<List<RocketInfo>> =
        repo.getRocketList().map(::response2UI)

    private fun response2UI(response: List<RocketAllListItem>): List<RocketInfo> {
        return object : Mapper<RocketAllListItem, RocketInfo>() {
            override fun map(value: RocketAllListItem): RocketInfo {
                with(value) {
                    return RocketInfo(
                        id = 0,
                        rocketName = name ?: "",
                        country = country ?: "",
                        company = company ?: "",
                        isfavorite = false,
                        imageUrl = flickr_images?.get(0) ?: "",
                        description = description ?: ""
                    )
                }
            }
        }.map(response)
    }
}