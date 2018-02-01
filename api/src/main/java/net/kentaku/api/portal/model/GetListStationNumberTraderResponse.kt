package net.kentaku.api.portal.model

import com.squareup.moshi.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import net.kentaku.api.shared.model.DktApiResponse
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class GetListStationNumberTraderResponse(
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
          name = "shop_count"
      )
      val shopCount: Int
  )
}
