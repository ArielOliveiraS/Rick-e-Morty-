package com.example.rickmorty.api

import com.example.rickmorty.model.CharacterResult
import io.reactivex.Single
import retrofit2.http.GET

interface ApiRickMorty {
    @GET("character/")
    fun getCharacter(): Single<CharacterResult>
}