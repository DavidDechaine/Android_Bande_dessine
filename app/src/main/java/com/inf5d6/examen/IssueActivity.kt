package com.inf5d6.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inf5d6.examen.adaptors.IssueAdaptor
import com.inf5d6.examen.viewModelFactory.IssueViewModelFactory
import com.inf5d6.examen.viewModels.ComicsViewModel
import com.inf5d6.examen.viewModels.IssueViewModel

class IssueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue)
        val showId = this.intent.getIntExtra("id", 0)
        val issueVmFactory =
            IssueViewModelFactory(this.application,showId)

        val issueVm = ViewModelProvider(
            this, issueVmFactory).get(IssueViewModel::class.java)

        val title = this.findViewById<TextView>(R.id.issueTitle)
        val description = this.findViewById<TextView>(R.id.issueDesc)
        val recyclerIssue = this.findViewById<RecyclerView>(R.id.rvPages)
        recyclerIssue.layoutManager = LinearLayoutManager(this)

        issueVm.issueInfo.observe(this){
            title.text = it.title
            description.text = it.description
            recyclerIssue.adapter = IssueAdaptor(it.pages)

        }
    }
}