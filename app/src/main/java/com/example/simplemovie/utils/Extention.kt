package com.example.simplemovie.utils

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun launch(context: CoroutineContext = Dispatchers.Main, block: suspend () -> Unit) {
    CoroutineScope(context).launch {
        block()
    }
}


fun showToast(message: String , context: Context){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}