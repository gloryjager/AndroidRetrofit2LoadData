/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

/**
 * URLビルダー
 * Created by tsuyosh on 17/10/25.
 */
interface DktUrlBuilder {
    fun build(): String

    fun build(path: String, params: List<Pair<String, String>>): String {
        val qs = params.map {
            it.toQueryString()
        }.joinToString("&")

        return if (path.indexOf("?") != -1) {
            path + "&" + qs
        } else {
            path + "?" + qs
        }
    }
}