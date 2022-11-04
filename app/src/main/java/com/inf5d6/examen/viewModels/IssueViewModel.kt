package com.inf5d6.examen.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.inf5d6.examen.models.Issue
import com.inf5d6.examen.repositories.IssueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IssueViewModel (val app: Application, id: Int) : AndroidViewModel(app) {
    var issueInfo: MutableLiveData<Issue> = MutableLiveData()
    val issueRepo = IssueRepository(getApplication())
    init{
        viewModelScope.launch(Dispatchers.IO) {
            issueRepo.loadIssue(issueInfo,id)
        }
    }
}