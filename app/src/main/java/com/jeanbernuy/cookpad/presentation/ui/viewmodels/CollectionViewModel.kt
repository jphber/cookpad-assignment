package com.jeanbernuy.cookpad.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.domain.CollectionRepository
import kotlinx.coroutines.Dispatchers

class CollectionViewModel(private val collectionRepository: CollectionRepository) : ViewModel() {

    val fetchAllDataCollections = liveData(Dispatchers.IO) {
        try {
            emit(collectionRepository.fetchAllCollections())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}