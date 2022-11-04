package com.inf5d6.examen.models

data class Comic(
    val issueId: Int,
    val coverURL: String,
    val description: String,
    val numero: Int,
    val pubdate: String,
    val title: String
)