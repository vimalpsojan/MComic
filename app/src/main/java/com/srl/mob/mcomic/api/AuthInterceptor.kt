package com.srl.mob.mcomic.api

import com.srl.mob.mcomic.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Class to add auth in rest request
 */
class AuthInterceptor : Interceptor
{
    override fun intercept(chain: Interceptor.Chain?): Response?
    {
        val original = chain?.request()
        val originalHttpUrl = original?.url()
        val ts=System.currentTimeMillis()
        val url = originalHttpUrl?.newBuilder()?.
            addQueryParameter("apikey", BuildConfig.apikey)?.
            addQueryParameter("ts","$ts")?.
            addQueryParameter("hash",gethash(ts))?.
            build()

        // Request customization: add request headers
        val requestBuilder = original?.newBuilder()?.url(url)

        val request = requestBuilder?.build()
        return chain?.proceed(request)
    }

    /**
     * Generate hash
     *
     * @param ts time in milliseconds
     */
    fun gethash(ts:Long):String
    {
        /*
        md5(ts+privateKey+publicKey)
         */
        val hasStr="$ts${BuildConfig.privateKey+BuildConfig.apikey}"
        val m= MessageDigest.getInstance("MD5")
        return BigInteger(1, m.digest(hasStr.toByteArray())).toString(16)
    }
}