/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.banner

import com.squareup.moshi.Moshi
import io.reactivex.schedulers.Schedulers
import net.kentaku.api.banner.urlbuilder.BannerUrlBuilder
import net.kentaku.api.shared.moshiadapter.ApplicationJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by tsuyosh on 17/12/24.
 */
class BannerTest {
    private val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    private val moshi = Moshi.Builder()
            .add(ApplicationJsonAdapterFactory.INSTANCE)
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .baseUrl("https://proxy.kentaku-d.com/")
            .build()

    private val api = retrofit.create(BannerApi::class.java)

    @Test
    fun testBanner() {
        val url = BannerUrlBuilder(
                base = "http://153.120.92.84/callAPI",
                version = "master"
        ).build()

        val response = api.banner(url)
                .subscribeOn(Schedulers.io())
                .test().await().assertNoErrors().values().first()
        println(response)
    }
}