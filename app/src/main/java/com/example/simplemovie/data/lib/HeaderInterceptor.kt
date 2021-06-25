package com.example.simplemovie.data.lib


import android.preference.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor(
    private val headers: HashMap<String, String>,
    private val preferenceManager: PreferenceManager
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        mapAccessToken()

        val request = mapHeaders(chain)

        return chain.proceed(request)
    }

    private fun mapAccessToken() {
//        headers["Authorization"] = preferenceManager.getAccessToken().orEmpty()
    }

    private fun mapHeaders(chain: Interceptor.Chain): Request {
        val original = chain.request()

        val requestBuilder = original.newBuilder()

        val host = original.url.host

//        if (host.contains("zomato")) {
//            headers["user-key"] = preferenceManager.getString(UserPreferenceKey.ACCESS_TOKEN, "")
//        }

        for ((key, value) in headers) {
            requestBuilder.addHeader(key, value)
        }
        return requestBuilder.build()
    }
}
