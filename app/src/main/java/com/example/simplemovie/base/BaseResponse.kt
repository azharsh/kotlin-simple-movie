package com.example.simplemovie.base

data class BaseResponse<T>(
    var status : String ? = null,
    var code : Int ? = null,
    var data : T ? = null
)