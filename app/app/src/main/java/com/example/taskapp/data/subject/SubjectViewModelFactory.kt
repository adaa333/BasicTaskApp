package com.example.taskapp.data.subject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SubjectViewModelFactory(private val repository: SubjectRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubjectViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SubjectViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
