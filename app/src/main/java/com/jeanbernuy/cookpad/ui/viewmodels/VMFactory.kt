package com.jeanbernuy.cookpad.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeanbernuy.cookpad.domain.CollectionRepository

class VMFactory(private val repository: CollectionRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CollectionRepository::class.java)
            .newInstance(repository)
    }
}