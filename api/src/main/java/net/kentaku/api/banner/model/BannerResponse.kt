/*
 * Copyright (C) Daito Trust Construction Co., Ltd. All Rights Reserved.
 */

package net.kentaku.api.banner.model

import com.squareup.moshi.Json
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

/**
 * Created by tsuyosh on 17/12/24.
 */
@JsonSerializable
data class BannerResponse(
        @Json(name = "result")
        override val result: Int,

        @Json(name = "message")
        override val message: String,

        @Json(name = "data")
        val data: List<DataItem>
) : DktApiResponse {
    @JsonSerializable
    data class DataItem(
            @Json(name = "url_data")
            val urlData: UrlDataItem,

            @Json(name = "order")
            val order: Int
    ) {
        @JsonSerializable
        data class UrlDataItem(
                @Json(name = "top_img_url")
                val topImgUrl: String,

                @Json(name = "detail_web_view_url")
                val detailWebViewUrl: String
        )
    }
}