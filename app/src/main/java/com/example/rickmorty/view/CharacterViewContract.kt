package com.example.rickmorty.view

import com.example.rickmorty.model.character.Characters

/**
 * Created by arieloliveira on 26/10/20 for RickMorty.
 */
interface CharacterViewContract {
    fun loadCharacterDetail(character: Characters)
}