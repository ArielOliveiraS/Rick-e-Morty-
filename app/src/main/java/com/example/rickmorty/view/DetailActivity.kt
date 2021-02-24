package com.example.rickmorty.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rickmorty.R
import com.example.rickmorty.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setHomeButtonEnabled(true);

        val viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
        val idCharacter = intent.getIntExtra(ID, -1)


        viewModel.getCharacter(idCharacter)

        viewModel.characterDetail.observe(this, Observer {
            Picasso.get().load(it.image).into(movieImageDetail1)
            movieTitleDetails1.text = it.name
            movieDurationDetail1.text = resources.getString(R.string.specie, it.species)
            movieReleaseYearDetail1.text = resources.getString(R.string.status, it.status)
            movieOverview1.text = resources.getString(R.string.planet, it.location.name)

            characterListButton.text = resources.getString(R.string.character_list)

            val episodes = it.episode.map {
                it.replace("https://rickandmortyapi.com/api/episode/", "")
            } as ArrayList<String>

            characterListButton.setOnClickListener {
                val intentEpisode = Intent(this, EpisodesActivity::class.java)
                intentEpisode.putStringArrayListExtra(EPISODES_ID, episodes)
                startActivity(intentEpisode)

            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        return true
    }
}