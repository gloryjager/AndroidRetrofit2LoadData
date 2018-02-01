package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListCityNumberPropertyResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "cities"
    )
    val cities: List<CitiesItem>
) : DktApiResponse {
  @JsonSerializable
  data class CitiesItem(
      @Json(
          name = "prefecture_id"
      )
      val prefectureId: Int,
      @Json(
          name = "city_id"
      )
      val cityId: Int,
      @Json(
          name = "city_name"
      )
      val cityName: String,
      @Json(
          name = "property_count"
      )
      val propertyCount: Int
  )
}
