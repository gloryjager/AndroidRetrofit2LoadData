package net.kentaku.api.portal.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetMemberInfoResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "nickname"
    )
    val nickname: String,
    @Json(
        name = "message"
    )
    override val message: String
) : DktApiResponse
