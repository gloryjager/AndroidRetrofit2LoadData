package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListTownNumberPropertyResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "towns"
    )
    val towns: List<TownsItem>
) : DktApiResponse {
  @JsonSerializable
  data class TownsItem(
      @Json(
          name = "city_id"
      )
      val cityId: Int,
      @Json(
          name = "town_id"
      )
      val townId: String,
      @Json(
          name = "town_name"
      )
      val townName: String,
      @Json(
          name = "property_count"
      )
      val propertyCount: Int
  )
}
