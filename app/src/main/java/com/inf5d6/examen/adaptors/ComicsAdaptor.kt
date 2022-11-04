package com.inf5d6.examen.adaptors

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.examen.IssueActivity
import com.inf5d6.examen.R
import com.inf5d6.examen.models.Comic
import com.squareup.picasso.Picasso

class ComicsAdaptor (private val comicsList: MutableList<Comic>):
    RecyclerView.Adapter<ComicsAdaptor.ComicViewHolder>() {

    class ComicViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comics_item, parent, false)
        return ComicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val imgComic = holder.view.findViewById<ImageView>(R.id.comicImg)
        val comicShowId = comicsList[position].issueId
        Picasso.get().load(this.comicsList[position].coverURL).into(imgComic)
        imgComic.setOnClickListener{
            val intent = Intent(it.context, IssueActivity::class.java)
            intent.putExtra("id", comicShowId)
            it.context.startActivity(intent)

        }
    }

}