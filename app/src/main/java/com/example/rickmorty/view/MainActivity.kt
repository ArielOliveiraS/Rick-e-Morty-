package com.example.rickmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmorty.R
import com.example.rickmorty.model.Results
import com.example.rickmorty.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = mutableListOf<Results>()
    private val adapter = CharacterRecyclerViewAdapter(list)

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
}