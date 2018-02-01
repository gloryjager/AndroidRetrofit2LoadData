/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import net.kentaku.geo.model.Location

/**
 * Created by tsuyosh on 17/11/01.
 */

fun Location.toQueryParams(): List<Pair<String, String>> {
    return listOf(
            Pair("latitude", (latitude * 3600000).toInt().toString()),
            Pair("longitude", (longitude * 3600000).toInt().toString())
    )
}