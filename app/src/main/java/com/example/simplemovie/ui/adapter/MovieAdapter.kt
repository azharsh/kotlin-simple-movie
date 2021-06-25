package com.example.simplemovie.ui.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.databinding.ItemMovieBinding
import com.example.simplemovie.ui.DetailActivity
import com.example.simplemovie.ui.MainActivity
import com.example.simplemovie.utils.Constant.API_KEY
import com.example.simplemovie.utils.Constant.IMG_URL
import com.squareup.picasso.Picasso

class MovieAdapter(
    val listData: ArrayList<MovieModel>,
    val mainActivity: MainActivity
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun getItemCount(): Int = listData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieModel = listData[position]
        holder.bind(movieModel)
    }

    fun setData(newdata: List<MovieModel>) {
        listData.clear()
        listData.addAll(newdata)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val itemMovieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root) {
        fun bind(movieModel: MovieModel) {

            val imgurl = IMG_URL + listData[position].poster_path + "?api_key=" + API_KEY

            Picasso.get().load(IMG_URL + imgurl + "?api_key=" + API_KEY)
                .into(itemMovieBinding.imgMovie)

            Log.d("imaje" , imgurl)

            itemMovieBinding.imgMovie.setOnClickListener {
                val intent = Intent(mainActivity, DetailActivity::class.java)
                mainActivity.startActivity(intent)
            }

            itemMovieBinding.favBtn.setOnClickListener {

            }

        }
    }
}