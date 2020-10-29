package com.example.rickmorty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.R
import com.example.rickmorty.model.character.Characters
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterRecyclerViewAdapter(var list: MutableList<Characters>, val viewContract: CharacterViewContract):
        RecyclerView.Adapter<CharacterRecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = list[position]
        holder.onBind(characters)

        holder.itemView.setOnClickListener {
            viewContract.loadCharacterDetail(characters)
        }
    }

    fun updateList(newList: MutableList<Characters>) {
        this.list.removeAll(list)
        if (newList != null) {
            this.list = newList
        }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(character: Characters) {
            itemView.characterName.text = character.name
            Picasso.get().load(character.image).into(itemView.characterImageView)
        }
    }

}
