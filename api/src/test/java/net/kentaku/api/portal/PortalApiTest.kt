/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.portal

import com.squareup.moshi.Moshi
import net.kentaku.api.shared.moshiadapter.ApplicationJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by tsuyosh on 17/10/27.
 */
open class PortalApiTest {
    val baseUrl = "https://www.eheya.net"

    val moshi: Moshi by lazy {
        Moshi.Builder()
                .add(ApplicationJsonAdapterFactory.INSTANCE)
                .build()
    }

    val api: DktPortalApi by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()

        retrofit.create(DktPortalApi::class.java)
    }
}