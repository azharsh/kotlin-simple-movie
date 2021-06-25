package com.example.simplemovie.data.lib

import android.preference.PreferenceManager
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

        //    if (host.contains("zomato")) {
        //         params["user_key"] = preferenceManager.getString(UserPreferenceKey.ACCESS_TOKEN, "")
        //     }

        //for ((key, value) in params) {
        //  builder.addQueryParameter(key, value)
        //}

        return builder.build()
    }
}