package net.kentaku.api.kentaku.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListStationCommutingResponse(
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
          name = "station_id"
      )
      val stationId: String,
      @Json(
          name = "station_name"
      )
      val stationName: String,
      @Json(
          name = "property_count"
      )
      val propertyCount: Int,
      @Json(
          name = "line_name"
      )
      val lineName: String,
      @Json(
          name = "minute"
      )
      val minute: Int,
      @Json(
          name = "change"
      )
      val change: Int
  )
}
