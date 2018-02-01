/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.exception

import net.kentaku.api.shared.model.DktApiResponse

/**
 * Created by tsuyosh on 17/12/19.
 */
class ApiException(
        val response: DktApiResponse,
        message: String? = response.message,
        t: Throwable? = null
): RuntimeException(message, t) {
    override fun toString(): String {
        return "ApiException(response=${response}, message=${message}, cause=${cause})"
    }
}