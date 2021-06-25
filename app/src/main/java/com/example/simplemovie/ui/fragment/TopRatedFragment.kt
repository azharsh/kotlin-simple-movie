package com.example.simplemovie.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.simplemovie.R
import com.example.simplemovie.base.BaseFragment
import com.example.simplemovie.databinding.FragmentListBinding
import com.example.simplemovie.ui.MainActivity

class TopRatedFragment(val mainActivity: MainActivity) : BaseFragment(R.layout.fragment_list) {

    companion object {
        fun newInstance(mainActivity: MainActivity) =
            TopRatedFragment(mainActivity)
    }

    private var fragmentListBinding : FragmentListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListBinding.bind(view)
        fragmentListBinding = binding

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