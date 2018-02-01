/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.urlbuilder

import java.net.URLEncoder

/**
 * Created by tsuyosh on 17/11/01.
 */
fun Pair<String, String>.toQueryString(encoding: String = "UTF-8")
        = URLEncoder.encode(first, encoding) + "=" + URLEncoder.encode(second, encoding)
