package com.example.simplemovie.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.simplemovie.R
import com.example.simplemovie.base.BaseActivity
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.databinding.ActivityMainBinding
import com.example.simplemovie.ui.adapter.ViewPagerAdapter
import com.example.simplemovie.ui.fragment.FavouriteFragment
import com.example.simplemovie.ui.fragment.PopularFragment
import com.example.simplemovie.ui.fragment.TopRatedFragment
import com.example.simplemovie.ui.viewmodel.MovieViewModel
import com.example.simplemovie.utils.launch
import com.google.android.material.tabs.TabLayout
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    var fragmentList: MutableList<Fragment?>? = ArrayList()
    lateinit var adapter: ViewPagerAdapter

    private lateinit var binding: ActivityMainBinding
    private val movieViewModel: MovieViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fragmentList?.add(PopularFragment.newInstance(this))
        fragmentList?.add(TopRatedFragment.newInstance(this))
        fragmentList?.add(FavouriteFragment.newInstance(this))

        adapter = ViewPagerAdapter(supportFragmentManager, fragmentList)

        binding.viewPagerMovie.adapter = adapter
        binding.viewPagerMovie.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                binding.tabLayout
            )
        )


    }

    fun updateMovie(movieModel: MovieModel) {
        launch {
            movieViewModel.getPopularMovieLocal().observe(this, Observer {
                it.forEach { m ->
                    if (m.id == movieModel.id) {
                        launch {
                            movieViewModel.updatePopular(movieModel)
                        }
                    }
                }
            })

            movieViewModel.getTopRatedMovieLocal().observe(this, Observer {
                it.forEach { m ->
                    if (m.id == movieModel.id) {
                        launch {
                            movieViewModel.updateTopRated(movieModel)
                        }
                    }
                }
            })
        }
    }

    override fun attachView() {

    }

    override fun detachView() {

    }
}