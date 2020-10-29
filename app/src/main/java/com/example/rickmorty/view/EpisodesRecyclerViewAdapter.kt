package com.example.rickmorty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.R
import com.example.rickmorty.model.character.Episode
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodesRecyclerViewAdapter(var list: MutableList<Episode>) :
    RecyclerView.Adapter<EpisodesRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_episode, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = list[position]
        holder.onBind(characters)
    }

    fun updateList(newList: MutableList<Episode>) {
        this.list.removeAll(list)
        if (newList != null) {
            this.list = newList
        }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(episode: Episode) {
            itemView.episodeView.text = episode.episode
            itemView.episodeNameView.text = episode.name
        }
    }
}
