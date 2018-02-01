package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class SetFavoritePropertyListResponse(@Json(
    name = "result"
)
override val result: Int, @Json(
    name = "message"
)
override val message: String) : DktApiResponse
