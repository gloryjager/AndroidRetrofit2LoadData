/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.proxy.model

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

/**
 * Created by tsuyosh on 17/12/14.
 */
@JsonSerializable
data class FeedbackRequest(
        @Json(name = "body")
        val body: String,

        @Json(name = "isCrashed")
        val isCrashed: Boolean,

        @Json(name = "udid")
        val udid: String? = null,

        @Json(name = "os")
        val os: Int = 2,

        @Json(name = "osVersion")
        val osVersion: String,

        @Json(name = "appVersion")
        val appVersion: String,

        @Json(name = "deviceName")
        val deviceName: String
)