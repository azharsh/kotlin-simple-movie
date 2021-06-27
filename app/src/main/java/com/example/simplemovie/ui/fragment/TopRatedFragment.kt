package com.example.simplemovie.ui.fragment

import android.os.Bundle
import android.view.View
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

class TopRatedFragment(val mainActivity: MainActivity) : BaseFragment(R.layout.fragment_list) {

    companion object {
        fun newInstance(mainActivity: MainActivity) =
            TopRatedFragment(mainActivity)
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

        getLocalData()

    }

    private fun getLocalData() {
        launch {
            movieViewModel.getTopRatedMovieLocal().observe(viewLifecycleOwner, Observer {
                if (it.isEmpty()) {
                    getApiData()
                } else {
                    movieAdapter.setData(it)
                }
            })
        }
    }

    private fun getApiData() {
        launch {
            movieViewModel.getTopRatedMovie().observe(viewLifecycleOwner, Observer {
                movieAdapter.setData(it)
                launch {
                    movieViewModel.insertTopRated(it)
                }
            })
        }
    }

    override fun onResume() {
        getLocalData()
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