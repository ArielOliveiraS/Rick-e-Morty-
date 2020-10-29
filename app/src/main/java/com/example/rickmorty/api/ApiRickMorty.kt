package com.example.rickmorty.api

import com.example.rickmorty.model.character.Characters
import com.example.rickmorty.model.character.CharactersResult
import com.example.rickmorty.model.character.Episode
import com.example.rickmorty.model.location.PlanetResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRickMorty {
    @GET("character/")
    fun getCharacter(): Single<CharactersResult>

    @GET("character/{id}")
    fun getCharacterId(@Path("id") id: Int): Single<Characters>

    @GET("location/")
    fun getLocation(): Single<PlanetResult>

    @GET("episode/{id}")
    fun getEpisode(@Path("id") id: Int): Single<Episode>

    @GET("episode/{id}")
    fun getEpisodesList(@Path("id") id: ArrayList<String>): Single<List<Episode>>
}