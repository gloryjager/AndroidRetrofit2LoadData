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
data class DeletePushConditionRequest(
        @Json(name = "storedConditionIds")
        val storedConditionIds: String
)