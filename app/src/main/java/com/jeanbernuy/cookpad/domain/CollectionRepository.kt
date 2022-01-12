package com.jeanbernuy.cookpad.domain

import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.data.model.Collection

interface CollectionRepository {
    suspend fun fetchAllCollections(): Resource<List<Collection>>
}