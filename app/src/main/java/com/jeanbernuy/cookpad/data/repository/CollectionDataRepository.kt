package com.jeanbernuy.cookpad.data.repository

import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.data.DataSource
import com.jeanbernuy.cookpad.data.model.Collection
import com.jeanbernuy.cookpad.domain.CollectionRepository


class CollectionDataRepository(private val dataSource: DataSource) : CollectionRepository {

    override suspend fun fetchAllCollections(): Resource<List<Collection>> {
        return dataSource.fetchAllDataCollection()
    }
}