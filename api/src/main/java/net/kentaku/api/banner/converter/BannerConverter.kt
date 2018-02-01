/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.banner.converter

import net.kentaku.api.banner.model.BannerResponse
import net.kentaku.banner.model.Banner

/**
 * Created by tsuyosh on 17/12/24.
 */

fun BannerResponse.toBanners(): List<Banner> {
    return this.data.map {
        Banner(
                topImageUrl = it.urlData.topImgUrl,
                detailWebViewUrl = it.urlData.detailWebViewUrl,
                order = it.order
        )
    }
}
