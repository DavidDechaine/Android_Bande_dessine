package com.inf5d6.examen.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.examen.R
import com.squareup.picasso.Picasso

class IssueAdaptor (private val pages : List<String>):
    RecyclerView.Adapter<IssueAdaptor.IssueViewHolder>() {

    class IssueViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.issue_item, parent, false)
        return IssueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val pageImg = holder.view.findViewById<ImageView>(R.id.pageImg)
        Picasso.get().load(this.pages[position]).into(pageImg)
    }
}