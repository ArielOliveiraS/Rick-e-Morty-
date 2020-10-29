package com.example.rickmorty.model.character

/**
 * Created by arieloliveira on 30/09/20 for RickMorty.
 */
data class CharactersResult (
    val info: Info?,
    val results: MutableList<Characters>
)