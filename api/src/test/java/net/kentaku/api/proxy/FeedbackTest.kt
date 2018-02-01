/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy

import com.squareup.moshi.Moshi
import io.reactivex.schedulers.Schedulers
import net.kentaku.api.proxy.model.FeedbackRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by tsuyosh on 17/12/14.
 */
class FeedbackTest {
    private val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    private val moshi = Moshi.Builder()
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .baseUrl("https://api.kentaku-d.com/v1/kentaku/")
            .build()

    private val api = retrofit.create(ProxyApi::class.java)

    @Test
    fun testFeedback() {
        val request = FeedbackRequest(
                body = "テストです",
                isCrashed = false,
                osVersion = "8.1.0",
                appVersion = "1.0.0 (123)",
                deviceName = "Dummy Device"
        )

        val response = api.feedback(request)
                .subscribeOn(Schedulers.io())
                .test().await().assertNoErrors().values().first()
        println(response)
        Assert.assertEquals(0, response.result)
    }
}