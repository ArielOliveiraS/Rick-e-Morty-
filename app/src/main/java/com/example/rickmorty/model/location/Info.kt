package com.example.rickmorty.model.location

data class Info (
    val count: Long,
    val pages: Long,
    val next: String,
    val prev: Any? = null
)