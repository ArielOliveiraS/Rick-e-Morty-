package com.example.rickmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickmorty.model.character.Characters
import com.example.rickmorty.model.character.CharactersResult
import com.example.rickmorty.model.character.Episode
import com.example.rickmorty.model.location.PlanetResult
import com.example.tmdb.api.remote.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by arieloliveira on 30/09/20 for RickMorty.
 */
class CharacterViewModel: ViewModel() {

    val disposable = CompositeDisposable()
    private val error: MutableLiveData<String> = MutableLiveData()

    val characterResult: MutableLiveData<CharactersResult> = MutableLiveData()
    val characterDetail: MutableLiveData<Characters> = MutableLiveData()
    val characterEpisodes: MutableLiveData<List<Episode>> = MutableLiveData()


    val locationResult: MutableLiveData<PlanetResult> = MutableLiveData()

    fun getAllCharacters() {
        disposable.add(
            RetrofitService.service.getCharacter()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    characterResult.value = it
                }, { e ->
                    error.value = e.message
                })

        )
    }

    fun getCharacter(id : Int) {
        disposable.add(
            RetrofitService.service.getCharacterId(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    characterDetail.value = it
                }, { e ->
                    error.value = e.message
                })

        )
    }
//
//    fun getEpisode(id : Int) {
//        disposable.add(
//            RetrofitService.service.getEpisode(id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    characterEpisodes.value = it
//                }, { e ->
//                    error.value = e.message
//                })
//        )
//    }

    fun getEpisodesList(id : ArrayList<String>) {
        disposable.add(
            RetrofitService.service.getEpisodesList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    characterEpisodes.value = it
                }, { e ->
                    error.value = e.message
                })
        )
    }
    fun getAllPlanets() {
        disposable.add(
            RetrofitService.service.getLocation()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    locationResult.value = it
                }, { e ->
                    error.value = e.message
                })
        )
    }

}