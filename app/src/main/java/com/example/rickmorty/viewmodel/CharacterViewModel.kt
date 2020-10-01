package com.example.rickmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickmorty.model.CharacterResult
import com.example.tmdb.api.remote.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by arieloliveira on 30/09/20 for RickMorty.
 */
class CharacterViewModel: ViewModel() {

    val disposable = CompositeDisposable()
    val characterResult: MutableLiveData<CharacterResult> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

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
}