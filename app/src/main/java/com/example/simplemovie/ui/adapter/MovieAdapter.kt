package com.example.simplemovie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.databinding.ItemMovieBinding

class MovieAdapter(val listData : List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun getItemCount(): Int = listData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieModel : MovieModel = listData[position]
        holder.bind(movieModel)
    }


    inner class ViewHolder(itemMovieBinding: ItemMovieBinding): RecyclerView.ViewHolder(itemMovieBinding.root) {
        fun bind(movieModel: MovieModel) {

        }
    }
}