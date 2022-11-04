package com.inf5d6.examen.models

data class Issue(
    val issueId: Int,
    val title: String,
    val description: String,
    val pages: List<String>
)