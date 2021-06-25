package com.example.simplemovie.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simplemovie.R
import com.example.simplemovie.base.BaseFragment
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.databinding.FragmentListBinding
import com.example.simplemovie.ui.MainActivity
import com.example.simplemovie.ui.adapter.MovieAdapter

class PopularFragment(val mainActivity: MainActivity) : BaseFragment(R.layout.fragment_list) {

    companion object {
        fun newInstance(mainActivity: MainActivity) =
            PopularFragment(mainActivity)
    }

    private var fragmentListBinding : FragmentListBinding? = null

    val listData = mutableListOf<MovieModel>()
    private lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListBinding.bind(view)
        fragmentListBinding = binding

//        for (i in 1..8){
//            listData.add(MovieModel())
//        }

        movieAdapter =  MovieAdapter(listData)

        fragmentListBinding?.recMovie?.layoutManager =  GridLayoutManager(context, 2)
        fragmentListBinding?.recMovie?.adapter = movieAdapter

    }

    private fun getData(){

    }

    override fun onDestroyView() {
        fragmentListBinding = null
        super.onDestroyView()
    }


    override fun attachView() {

    }

    override fun detachView() {

    }


}