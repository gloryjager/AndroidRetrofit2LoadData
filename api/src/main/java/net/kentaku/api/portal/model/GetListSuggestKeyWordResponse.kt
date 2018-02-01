package net.kentaku.api.portal.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListSuggestKeyWordResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "cities"
    )
    val cities: List<CitiesItem>,
    @Json(
        name = "stations"
    )
    val stations: List<StationsItem>,
    @Json(
        name = "message"
    )
    override val message: String
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
      val cityName: String
  )

  @JsonSerializable
  data class StationsItem(
      @Json(
          name = "prefecture_id"
      )
      val prefectureId: Int,
      @Json(
          name = "city_id"
      )
      val cityId: Int,
      @Json(
          name = "val_code"
      )
      val valCode: Int,
      @Json(
          name = "station_name"
      )
      val stationName: String
  )
}
