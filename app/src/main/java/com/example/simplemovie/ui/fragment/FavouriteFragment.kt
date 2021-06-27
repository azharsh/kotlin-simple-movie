package com.example.simplemovie.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simplemovie.R
import com.example.simplemovie.base.BaseFragment
import com.example.simplemovie.databinding.FragmentListBinding
import com.example.simplemovie.ui.MainActivity
import com.example.simplemovie.ui.adapter.MovieAdapter
import com.example.simplemovie.ui.viewmodel.MovieViewModel
import com.example.simplemovie.utils.launch
import org.koin.android.ext.android.inject

class FavouriteFragment(val mainActivity: MainActivity) : BaseFragment(R.layout.fragment_list) {

    companion object {
        fun newInstance(mainActivity: MainActivity) =
            FavouriteFragment(mainActivity)
    }

    private var fragmentListBinding: FragmentListBinding? = null
    private val movieViewModel: MovieViewModel by inject()


    private lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListBinding.bind(view)
        fragmentListBinding = binding

        movieAdapter = MovieAdapter(arrayListOf(), mainActivity)

        fragmentListBinding?.recMovie?.layoutManager = GridLayoutManager(context, 2)
        fragmentListBinding?.recMovie?.adapter = movieAdapter

        getPopuLarData()

    }

    private fun getPopuLarData() {
        launch {
            movieViewModel.getPopularMovieLocal().observe(viewLifecycleOwner, Observer {
                val filteredData =  it.filter { f -> f.favorite }
                movieAdapter.setData(filteredData)
                getTopRatedData()
            })
        }
    }

    private fun getTopRatedData(){
        launch {
            movieViewModel.getTopRatedMovieLocal().observe(viewLifecycleOwner, Observer {
                val filteredData =  it.filter { f -> f.favorite }
                movieAdapter.addData(filteredData)
                genereteBadge()
            })
        }
    }

    private fun genereteBadge(){
        mainActivity.setBadge(movieAdapter.itemCount)
    }

    override fun onResume() {
        getPopuLarData()
        super.onResume()
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