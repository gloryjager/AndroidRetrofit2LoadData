/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy.model

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

/**
 * Created by tsuyosh on 17/12/18.
 */
@JsonSerializable
data class SetPushConditionRequest(
        @Json(name = "os")
        val os: Int = 1,

        @Json(name = "deviceToken")
        val deviceToken: String,

        @Json(name = "searchType")
        val searchType: Int,

        @Json(name = "searchCondition")
        val searchCondition: String,

        @Json(name = "createdAt")
        val createdAt: Float
)