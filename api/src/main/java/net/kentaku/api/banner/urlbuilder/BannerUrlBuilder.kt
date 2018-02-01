/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.banner.urlbuilder

import net.kentaku.api.shared.urlbuilder.DktUrlBuilder
import java.net.URLEncoder

/**
 * Created by tsuyosh on 17/12/24.
 */
class BannerUrlBuilder(
        val base: String,
        val version: String
) : DktUrlBuilder {
    override fun build(): String {
        val params = listOf(
                Pair("function", "Banner"),
                Pair("type", "mobile"),
                Pair("version", version)
        )
        return URLEncoder.encode(build(base, params), "UTF-8")
    }
}