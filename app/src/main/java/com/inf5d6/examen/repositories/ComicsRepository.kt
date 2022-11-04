package com.inf5d6.examen.repositories

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.inf5d6.examen.models.Comic

class ComicsRepository (private val app: Application){
    fun loadComics(comicList: MutableLiveData<MutableList<Comic>>) {
        val queue = Volley.newRequestQueue(app)
        val url = "https://comicstoreapi.herokuapp.com/comics"

        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                val arrayComics = Gson().fromJson(it, Array<Comic>::class.java)
                comicList.value = arrayComics.toMutableList()
            },
            {error->
                println("ERREUR: $error")
            })
        queue.add(request)
    }
}