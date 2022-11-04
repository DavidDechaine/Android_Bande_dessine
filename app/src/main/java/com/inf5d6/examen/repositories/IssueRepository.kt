package com.inf5d6.examen.repositories

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.inf5d6.examen.models.Comic
import com.inf5d6.examen.models.Issue

class IssueRepository (private val app: Application){
    fun loadIssue(comicList: MutableLiveData<Issue>, id: Int) {
        val queue = Volley.newRequestQueue(app)
        val url = "https://comicstoreapi.herokuapp.com/issue?issueId=$id"

        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                val issueInfo = Gson().fromJson(it, Issue::class.java)
                comicList.value = issueInfo
            },
            {error->
                println("ERREUR: $error")
            })
        queue.add(request)
    }
}