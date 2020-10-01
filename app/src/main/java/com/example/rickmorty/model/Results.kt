package com.example.rickmorty.model


/**
 * Created by arieloliveira on 30/09/20 for RickMorty.
 */
data class Results (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String?,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String?,
    val episode: List<String>,
    val url: String,
    val created: String
)