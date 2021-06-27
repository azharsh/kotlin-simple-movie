package com.example.simplemovie.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemovie.R
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.databinding.ItemMovieBinding
import com.example.simplemovie.ui.DetailActivity
import com.example.simplemovie.ui.MainActivity
import com.example.simplemovie.utils.Constant.API_KEY
import com.example.simplemovie.utils.Constant.IMG_URL
import com.google.gson.Gson
import com.squareup.moshi.Json
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
        holder.bind()
    }

    fun setData(newdata: List<MovieModel>) {
        listData.clear()
        listData.addAll(newdata)
        notifyDataSetChanged()
    }

    fun addData(newdata: List<MovieModel>) {
        listData.addAll(newdata)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val itemMovieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root) {
        fun bind() {

            var itemData = listData[position]

            val imgUrl = IMG_URL + itemData.poster_path + "?api_key=" + API_KEY

            Picasso.get().load(imgUrl)
                .into(itemMovieBinding.imgMovie)

            itemMovieBinding.titleMovie.text = itemData.title
            itemMovieBinding.genreMovie.text = itemData.release_date

            if (itemData.favorite){
                itemMovieBinding.favBtn.setImageResource(R.drawable.ic_baseline_favorite_24_red)
            }

            itemMovieBinding.imgMovie.setOnClickListener {
                val gson = Gson()
                val intent = Intent(mainActivity, DetailActivity::class.java)
                intent.putExtra("moviedata", gson.toJson(itemData))
                mainActivity.startActivity(intent)
            }

            itemMovieBinding.favBtn.setOnClickListener {
                itemData.favorite = !itemData.favorite
                mainActivity.updateMovie(itemData)
                notifyItemChanged(position)
            }

        }
    }
}