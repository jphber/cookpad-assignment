package com.jeanbernuy.cookpad.data.remote

import com.jeanbernuy.cookpad.data.model.Collections
import retrofit2.http.GET

interface WebService {
    @GET("collections")
    suspend fun getAllCollections():Collections

}