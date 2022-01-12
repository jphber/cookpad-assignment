package com.jeanbernuy.cookpad.data

import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.core.RestEngine
import com.jeanbernuy.cookpad.data.model.Collection
import com.jeanbernuy.cookpad.data.model.Collections

class DataSource {

    suspend fun fetchAllDataCollection(): Resource<Collections> {
        return Resource.Success(RestEngine.restEngine.getAllCollections())
    }
}