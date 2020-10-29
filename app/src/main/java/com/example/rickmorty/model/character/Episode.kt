package com.example.rickmorty.model.character

import com.google.gson.annotations.SerializedName

/**
 * Created by arieloliveira on 28/10/20 for RickMorty.
 */
data class Episode (
    val id: Long,
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)