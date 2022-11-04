package com.inf5d6.examen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.examen.adaptors.ComicsAdaptor
import com.inf5d6.examen.viewModels.ComicsViewModel

class ComicsActivity : AppCompatActivity() {
    private lateinit var comicsViewModel: ComicsViewModel
    companion object {
        const val SRVURL = "https://comicstoreapi.herokuapp.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_comics)

        this.comicsViewModel =
            ViewModelProvider(this).get(ComicsViewModel::class.java)

        val recyclerComic = this.findViewById<RecyclerView>(R.id.rvComics)
        recyclerComic.layoutManager = GridLayoutManager(this, 2)

        this.comicsViewModel.comics.observe(this){
            recyclerComic.adapter = ComicsAdaptor(it)
        }
    }
}