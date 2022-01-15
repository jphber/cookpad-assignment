package com.jeanbernuy.cookpad.presentation.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.data.model.Collections
import com.jeanbernuy.cookpad.domain.CollectionRepository
import com.jeanbernuy.cookpad.utils.CoroutineTestRule
import com.jeanbernuy.cookpad.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CollectionViewModelTest {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: CollectionViewModel

    @RelaxedMockK
    private lateinit var repository: CollectionRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = CollectionViewModel(repository)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun should_ReturnResourceFailure_When_IsErrorResult() = coroutineTestRule.runBlockingTest {
        //Given
        coEvery { repository.fetchAllCollections() } returns Resource.Failure(Exception())
        //When
        val value = viewModel.fetchAllDataCollections.getOrAwaitValue()
        //Then
        assertTrue(value is Resource.Failure)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun should_ReturnResourceSuccess_When_IsCorrectResult() = coroutineTestRule.runBlockingTest {
        //Given
        val collections = Collections()
        coEvery { repository.fetchAllCollections() } returns Resource.Success(collections)
        //When
        val valueTwo = viewModel.fetchAllDataCollections.getOrAwaitValue()
        //Then
        assertTrue(valueTwo is Resource.Success)
    }


}