/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.shared.model

/**
 * Created by tsuyosh on 17/10/24.
 */
interface DktApiResponse {
    val result: Int
    val message: String

    fun isSuccess() = result == 0
}