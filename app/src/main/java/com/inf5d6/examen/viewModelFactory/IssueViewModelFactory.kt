package com.inf5d6.examen.viewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inf5d6.examen.viewModels.IssueViewModel

class IssueViewModelFactory (val application: Application, private val issueId: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IssueViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return IssueViewModel(this.application, this.issueId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}