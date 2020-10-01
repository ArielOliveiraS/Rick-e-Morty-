package com.example.rickmorty.model

import com.google.gson.annotations.SerializedName

/**
 * Created by arieloliveira on 30/09/20 for RickMorty.
 */
data class CharacterResult (
    val info: Info?,
    val results: MutableList<Results>
)