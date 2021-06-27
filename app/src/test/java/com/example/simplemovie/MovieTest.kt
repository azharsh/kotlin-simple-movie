package com.example.simplemovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.simplemovie.data.movie.MovieDataStore
import com.example.simplemovie.data.movie.MovieRepository
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.data.movie.model.MovieResponse
import com.example.simplemovie.ui.viewmodel.MovieViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieModel: MovieModel

    private var movietRepo = Mockito.mock(MovieRepository::class.java)


    @Mock
    private lateinit var observer: Observer<List<MovieModel>>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(movietRepo)

        movieModel = MovieModel(
            id = 284053,
            adult = false,
            backdrop_path = "/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg",
            originalTitle = "Thor: Ragnarok",
            overview = "Thor is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the destruction of his home-world and the end of Asgardian civilization, at the hands of a powerful new threat, the ruthless Hela.",
            popularity = 157.283,
            poster_path = "/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg",
            release_date = "2017-10-25",
            title = "Thor: Ragnarok",
            video = false,
            voteAverage = 7.6,
            voteCount = 16039
        )

    }

    @Test
    fun getMovieData() {
        testCoroutineRule.runBlockingTest {
            val dummyModel = movieModel
            val movieLiveModel = mutableListOf<MovieModel>()
            movieLiveModel.addAll(listOf(dummyModel))
            Mockito.`when`(movietRepo.getPopularMovie(1))
                .thenReturn(MovieResponse(movieLiveModel))
            movieViewModel.getPopularMovie().observeForever(observer)
            Mockito.verify(movietRepo).getPopularMovie(1)
            Mockito.verify(observer).onChanged(listOf(dummyModel))
            movieViewModel.getPopularMovie().removeObserver(observer)
        }
    }

}