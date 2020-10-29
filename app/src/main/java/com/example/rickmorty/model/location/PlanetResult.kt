package com.example.rickmorty.model.location

import com.google.gson.annotations.SerializedName

data class PlanetResult (
    val info: Info?,
    val results: MutableList<Planet>
)