/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy.model

import com.squareup.moshi.Json
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

/**
 * Created by tsuyosh on 17/12/18.
 */
@JsonSerializable
data class SetPushConditionResponse(
        @Json(name = "result")
        override val result: Int,

        @Json(name = "message")
        override val message: String,

        @Json(name = "storedConditionId")
        val storedConditionId: String
): DktApiResponse