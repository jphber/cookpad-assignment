package com.jeanbernuy.cookpad.data

import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.core.RestEngine
import com.jeanbernuy.cookpad.data.model.Collection

class DataSource {

    suspend fun fetchAllDataCollection(): Resource<List<Collection>> {
        return Resource.Success(RestEngine.restEngine.getAllCollections().collection)
    }
}