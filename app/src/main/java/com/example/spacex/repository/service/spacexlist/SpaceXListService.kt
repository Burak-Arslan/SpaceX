package com.example.spacex.repository.service.spacexlist

import com.example.spacex.repository.service.spacexlist.reqres.RocketAllListItem
import retrofit2.http.GET
import retrofit2.http.POST

interface SpaceXListService {

    @GET("rockets")
    suspend fun getRocketList(): List<RocketAllListItem>
}
