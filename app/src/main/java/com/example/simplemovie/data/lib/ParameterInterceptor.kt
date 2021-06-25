package com.example.simplemovie.data.lib

import android.preference.PreferenceManager
import com.example.simplemovie.utils.Constant.API_KEY
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*

class ParameterInterceptor(
    private val params: HashMap<String, String>,
    private val preferenceManager: PreferenceManager
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val requestBuilder = original.newBuilder()
            .url(mapParameters(chain))


        val request = requestBuilder.build()
        return chain.proceed(request)
    }

    private fun mapParameters(chain: Interceptor.Chain): HttpUrl {
        val original = chain.request()
        val originalHttpUrl = original.url

        val builder = originalHttpUrl.newBuilder()

        val host = originalHttpUrl.host

        params["user_key"] = API_KEY

        for ((key, value) in params) {
          builder.addQueryParameter(key, value)
        }

        return builder.build()
    }
}