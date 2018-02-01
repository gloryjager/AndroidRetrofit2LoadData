/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy.model

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

/**
 * Created by tsuyosh on 17/12/19.
 */
@JsonSerializable
data class UpdateDeviceTokenRequest(
        @Json(name = "storedConditionIds")
        val storedConditionIds: List<String>,

        @Json(name = "deviceToken")
        val deviceToken: String
)