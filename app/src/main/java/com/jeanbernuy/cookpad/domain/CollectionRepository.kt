package com.jeanbernuy.cookpad.domain

import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.data.model.Collection
import com.jeanbernuy.cookpad.data.model.Collections

interface CollectionRepository {
    suspend fun fetchAllCollections(): Resource<Collections>
}