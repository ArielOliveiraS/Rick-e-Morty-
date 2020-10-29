package com.example.rickmorty.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.R
import com.example.rickmorty.model.character.Characters
import com.example.rickmorty.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*

const val ID = "id"
const val EPISODES_ID = "episodesId"

class MainActivity : AppCompatActivity(), CharacterViewContract {

    private val list = mutableListOf<Characters>()
    private val adapter = CharacterRecyclerViewAdapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)

        characterRecyclerView.adapter = adapter
        characterRecyclerView.layoutManager = GridLayoutManager(this, 2)

        viewModel.getAllCharacters()

        viewModel.characterResult.observe(this, Observer {
            adapter.updateList(it.results)
        })

    }

    override fun loadCharacterDetail(character: Characters) {
        val intent1 = Intent(this, DetailActivity::class.java)
        intent1.putExtra(ID, character.id)
        startActivity(intent1)
    }
}