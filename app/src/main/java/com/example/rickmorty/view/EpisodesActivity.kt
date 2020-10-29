package com.example.rickmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmorty.R
import com.example.rickmorty.model.character.Episode
import com.example.rickmorty.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.activity_episodes.*

class EpisodesActivity : AppCompatActivity() {

    private val list = mutableListOf<Episode>()
    private val adapter = EpisodesRecyclerViewAdapter(list)
   // private var episodesIds = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)

        val viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)

        episodesRecyclerView.adapter = adapter
        episodesRecyclerView.layoutManager = LinearLayoutManager(this)

        val episodesIds = intent.getStringArrayListExtra(EPISODES_ID)


        viewModel.getEpisodesList(episodesIds)

        viewModel.characterEpisodes.observe(this, Observer {



            adapter.updateList(it as MutableList<Episode>)

        })

    }
}