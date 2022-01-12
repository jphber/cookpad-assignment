package com.jeanbernuy.cookpad.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.domain.CollectionRepository
import kotlinx.coroutines.Dispatchers

class CollectionViewModel(private val collectionRepository: CollectionRepository) : ViewModel() {

    val fetchAllDataCollections = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(collectionRepository.fetchAllCollections())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}