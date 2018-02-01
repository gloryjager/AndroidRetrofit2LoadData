package net.kentaku.api.portal.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListStationNumberMergePropertyResponse(
    @Json(
        name = "result"
    )
    override val result: Int,
    @Json(
        name = "message"
    )
    override val message: String,
    @Json(
        name = "stations"
    )
    val stations: List<StationsItem>
) : DktApiResponse {
  @JsonSerializable
  data class StationsItem(
      @Json(
          name = "prefecture_id"
      )
      val prefectureId: Int,
      @Json(
          name = "station_id"
      )
      val stationId: Int,
      @Json(
          name = "station_name"
      )
      val stationName: String,
      @Json(
          name = "property_count"
      )
      val propertyCount: Int
  )
}
