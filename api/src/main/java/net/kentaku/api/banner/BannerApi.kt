/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.banner

import io.reactivex.Single
import net.kentaku.api.banner.model.BannerResponse
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by tsuyosh on 17/12/24.
 */
interface BannerApi {
    @GET
    fun banner(@Url url: String): Single<BannerResponse>
}