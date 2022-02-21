package com.example.spacex.ui.home

import com.example.core.util.ResProvider
import com.example.spacex.data.RocketRepository
import com.example.spacex.domain.spacexlist.SpaceXListUseCase
import com.example.spacex.repository.service.spacexlist.SpaceXRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

class FRHomeVMTest {

    @MockK
    private lateinit var useCase: SpaceXListUseCase

    @MockK(relaxed = true)
    private lateinit var resProvider: ResProvider

    @MockK
    private lateinit var viewModel: FRHomeVM

    @MockK
    private lateinit var repo: SpaceXRepository

    @MockK
    private lateinit var dataRepo: RocketRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        MockKAnnotations.init(this)
        viewModel = FRHomeVM(useCase, dataRepo)
    }

    @ExperimentalTime
    @Test
    fun `usecase not zero`() = runBlocking {
        viewModel.getRocketList().invokeOnCompletion {
            Assert.assertTrue(viewModel.rocketList.value?.size!! > 0)
        }
    }
}