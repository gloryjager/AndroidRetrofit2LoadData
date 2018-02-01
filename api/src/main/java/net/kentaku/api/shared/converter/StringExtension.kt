/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.converter

import java.net.URLEncoder

/**
 * Created by tsuyosh on 17/11/30.
 */

fun String.toUrlWithScheme(): String {
    if (this.isBlank()) return this

    val url = if (!startsWith("https://", true) || !startsWith("http://", true)) {
        // schemaが入ってないとproxyからnot foundが帰ってくるので
        "http://" + this
    } else {
        this
    }
    // TODO https://proxy.kentaku-d.com/の部分は可変にできるように
    return "https://proxy.kentaku-d.com/" + URLEncoder.encode(url, "UTF-8")
}
