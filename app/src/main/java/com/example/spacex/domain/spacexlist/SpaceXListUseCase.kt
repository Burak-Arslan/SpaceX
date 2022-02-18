package com.example.spacex.domain.spacexlist

import com.example.core.base.UseCase
import com.example.core.util.Mapper
import com.example.core.util.ResProvider
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI
import com.example.spacex.repository.service.spacexlist.SpaceXRepository
import com.example.spacex.repository.service.spacexlist.reqres.RocketAllListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SpaceXListUseCase @Inject constructor(
    private val resProvider: ResProvider,
    private val repo: SpaceXRepository
) : UseCase<Unit, List<RocketListUI>>() {

    override fun execute(params: Unit): Flow<List<RocketListUI>> =
        repo.getRocketList().map(::response2UI)

    private fun response2UI(response: List<RocketAllListItem>): List<RocketListUI> {
        return object : Mapper<RocketAllListItem, RocketListUI>() {
            override fun map(value: RocketAllListItem): RocketListUI {
                with(value) {
                    return RocketListUI(deneme = country)
                }
            }
        }.map(response)
    }
}