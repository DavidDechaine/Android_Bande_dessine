package com.inf5d6.examen.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.inf5d6.examen.models.Comic
import com.inf5d6.examen.repositories.ComicsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComicsViewModel (val app: Application) : AndroidViewModel(app) {
    var comics : MutableLiveData<MutableList<Comic>> = MutableLiveData(mutableListOf())
    init{
        viewModelScope.launch(Dispatchers.IO) {
            val comicRepo = ComicsRepository(getApplication())
            comicRepo.loadComics(comics)
        }
    }
}