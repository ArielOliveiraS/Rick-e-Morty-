package com.example.rickmorty.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.R
import com.example.rickmorty.model.character.Characters
import com.example.rickmorty.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*

const val ID = "id"
const val EPISODES_ID = "episodesId"

class MainActivity : AppCompatActivity(), CharacterViewContract, ViewTreeObserver.OnScrollChangedListener {

    private val list = mutableListOf<Characters>()
    private val adapter = CharacterRecyclerViewAdapter(list, this)
    private val layoutManager = GridLayoutManager( this, 2)
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)

        characterRecyclerView.adapter = adapter
        characterRecyclerView.layoutManager = layoutManager

        viewModel.getAllCharacters(page.toString())

        viewModel.characterResult.observe(this, Observer {
            adapter.updateList(it.results)
        })

      //  paginacao()
        characterRecyclerView.viewTreeObserver.addOnScrollChangedListener ( this )


    }

    override fun loadCharacterDetail(character: Characters) {
        val intent1 = Intent(this, DetailActivity::class.java)
        intent1.putExtra(ID, character.id)
        startActivity(intent1)
    }

    fun paginacao() {
        characterRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
             //   if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount //quantos itens tem visiveis
                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = adapter.itemCount //total de itens na pagina

                    if (visibleItemCount + pastVisibleItem >= total){
                        page += 1
                    }
          //      }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }


    override fun onScrollChanged() {
        val view = characterRecyclerView.getChildAt(characterRecyclerView.childCount -1) as View
        val topDetector = characterRecyclerView.scrollY
        val bottomDetector = view.bottom - (characterRecyclerView.height + characterRecyclerView.scrollY)

        if (topDetector <=0 ){

        }
    }
}