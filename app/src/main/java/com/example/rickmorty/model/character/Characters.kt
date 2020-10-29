package com.example.rickmorty.model.character

import com.example.rickmorty.model.character.Location
import com.example.rickmorty.model.character.Origin


/**
 * Created by arieloliveira on 30/09/20 for RickMorty.
 */
data class Characters (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String?,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String?,
    val episode: ArrayList<String>,
    val url: String,
    val created: String
)